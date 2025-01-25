/*
 * Copyright (C) 2012-2025 Zach Melamed
 *
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.common.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.common.codelist.EditionTypes;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.struct.JonixAudience;
import com.tectonica.jonix.common.struct.JonixAudienceRange;
import com.tectonica.jonix.common.struct.JonixLanguage;

import java.io.Serializable;
import java.util.List;

/**
 * Bundles together some descriptive information included in an ONIX Product
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseDescription implements Serializable {
    public EditionTypes editionType;
    public Integer editionNumber;
    public String productForm;
    public String numberOfPages;
    public List<JonixLanguage> languages;
    public List<JonixAudience> audiences;
    public String audienceDescription;
    public JonixAudienceRange audienceRange;

    /**
     * returns a 2-items array, containing the FROM and TO age-range values, or null if not indicated. This function
     * never returns null.
     */
    public Integer[] getFirstAudienceAgeRange() {
        if (audienceRange != null) {
            return getAudienceAgeRange(audienceRange);
        }
        return new Integer[] {null, null};
    }

    public String findLanguage(LanguageRoles requestedType) {
        JonixLanguage jonixLanguage = findJonixLanguage(requestedType);
        return (jonixLanguage == null) ? null : jonixLanguage.languageCode.description;
    }

    public JonixLanguage findJonixLanguage(LanguageRoles requestedType) {
        if (languages != null) {
            for (JonixLanguage lang : languages) {
                if (lang.languageRole == requestedType) {
                    return lang;
                }
            }
        }
        return null;
    }

    public static Integer[] getAudienceAgeRange(JonixAudienceRange audienceRange) {
        Integer[] ageRange = new Integer[] {null, null};
        AudienceRangeQualifiers qualifier = audienceRange.audienceRangeQualifier;
        if (qualifier == AudienceRangeQualifiers.Interest_age_years) {
            List<AudienceRangePrecisions> precisions = audienceRange.audienceRangePrecisions;
            List<String> values = audienceRange.audienceRangeValues;
            if (precisions.size() != values.size()) {
                // TODO: invalid ONIX
            } else {
                for (int i = 0; i < precisions.size(); i++) {
                    int value = Integer.parseInt(values.get(i));
                    if (value != 0) { // 0 has exact meaning as null, it's sometimes provided wrongly as such
                        switch (precisions.get(i)) {
                            case From:
                                ageRange[0] = value;
                                break;

                            case To:
                                ageRange[1] = value;
                                break;

                            case Exact:
                                ageRange[0] = value;
                                ageRange[1] = value;
                                break;

                            default:
                                throw new IllegalStateException();
                        }
                    }
                }
            }
        }
        return ageRange;
    }
}
