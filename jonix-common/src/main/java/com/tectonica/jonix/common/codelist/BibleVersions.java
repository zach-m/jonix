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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 83 (Bible version)
 */
interface CodeList83 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 83</b>
 * <p>
 * Description: Bible version
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist83">ONIX
 *      Codelist 83 in Reference Guide</a>
 */
public enum BibleVersions implements OnixCodelist, CodeList83 {
    /**
     * Alberto Vaccari - Pontificio Istituto Biblico
     */
    Alberto_Vaccari("ALV", "Alberto Vaccari"),

    /**
     * (AMP) A translation based on the American Standard Version and showing multiple options for the translation of
     * ancient text. Published in full in 1965. Sponsored by the Lockman Foundation
     */
    Amplified("AMP", "Amplified"),

    /**
     * Most popular Catholic Bible translation in Italian prior to the CEI translation in 1971
     */
    Antonio_Martini("ANM", "Antonio Martini"),

    /**
     * (ASV) A 1901 translation using verbal equivalence techniques with the purpose of Americanizing the REV
     */
    American_Standard("ASV", "American Standard"),

    /**
     * (LBLA) Spanish translation by the Lockman Foundation, first published in 1986 and updated in 1995, 1997. Only for
     * use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Biblia_de_las_Americas("BLA", "Biblia de las Americas"),

    /**
     * (NBLA) Updated Spanish translation by the Lockman Foundation, first published in 2005. Also known as Nueva Biblia
     * Latinoamericana de Hoy (NBLH), Nueva Biblia de los Hispanos (NBH), and Nueva Biblia Latinoamericana (NBL). Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nueva_Biblia_de_las_Americas("BLB", "Nueva Biblia de las Americas"),

    /**
     * A 1994 Spanish translation of the complete Catholic Bible by La Casa de la Biblia (representing the Spanish
     * Episcopal Conference) and approved by the Episcopal Conferences of Mexico, Colombia and Chile. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Biblia_de_America("BDA", "Biblia de América"),

    /**
     * (CEB) 2011 contemporary English translation of the Bible sponsored by the US-based Christian Resources
     * Development Corporation. The translation includes Old Testament, Apocrypha and New Testament, and is aimed to be
     * accessible to most English readers (minimum 7th grade reading age)
     */
    Common_English_Bible("CEB", "Common English Bible"),

    /**
     * Italian Episcopal Conference 1971 translation suitable for Italian Catholic liturgy. (Includes minor 1974
     * revision)
     */
    Conferenza_Episcopale_Italiana("CEI", "Conferenza Episcopale Italiana"),

    /**
     * New translation of the C.E.I. first published in 2008 - the version most widely used by the Italian Catholic
     * Church
     */
    Conferenza_Episcopale_Italiana_2008("CEN", "Conferenza Episcopale Italiana 2008"),

    /**
     * (CEV) A translation completed in 1995 and sponsored by the American Bible Society under the leadership of Barclay
     * Newman
     */
    Contemporary_English("CEV", "Contemporary English"),

    /**
     * 1968 Interfaith version promoted by the Italian Bible Society. Has a Catholic 'imprimateur', but its ecumenical
     * approach has Jewish, Protestant and Christian Orthodox approval
     */
    Concordata("CNC", "Concordata"),

    /**
     * Version based on original documents, edited by Giovanni Diodati in 1607, revised by Diodati in 1641 and again in
     * 1894. It is the reference version for many Italian Protestants
     */
    Diodati("DDI", "Diodati"),

    /**
     * (LND) Revision of the Diodati Bible dating to the 1990s, aiming at highest fidelity to original ancient Greek
     * (New Testament) and Hebrew (Old Testament) texts
     */
    Nuova_Diodati("DDN", "Nuova Diodati"),

    /**
     * (DRB) An early (1580-1609) English translation from the Latin Vulgate designed for Catholics and performed by
     * George Martin
     */
    DouayRheims("DOU", "Douay–Rheims"),

    /**
     * A German translation of the Bible for use in Roman Catholic churches
     */
    Einheitsubersetzung("EIN", "Einheitsübersetzung"),

    /**
     * (ESV) An update of the Revised Standard Version that makes 'modest' use of gender-free terminology
     */
    English_Standard("ESV", "English Standard"),

    /**
     * Finnish Bible translation
     */
    Biblia_1776("FBB", "Biblia (1776)"),

    /**
     * Finnish Bible translation
     */
    Raamattu_1933_1938("FRA", "Raamattu (1933/1938)"),

    /**
     * Finnish Bible translation
     */
    Raamattu_kansalle("FRK", "Raamattu kansalle"),

    /**
     * Finnish Bible translation
     */
    Raamattu_1992("FRM", "Raamattu (1992)"),

    /**
     * (GW) A 1995 translation by the World Bible Publishing Company using the English language in a manner to
     * communicate to the late 20th century American
     */
    Gods_Word("GDW", "God’s Word"),

    /**
     * (GEN) An early (1560) English version of the Bible translated by William Whittingham with strong Protestant
     * leanings
     */
    Geneva("GEN", "Geneva"),

    /**
     * (GNB, GNT) A translation sponsored by the American Bible Society. The New Testament was first published (as
     * 'Today's English Version' TEV) in 1966. The Old Testament was completed in 1976, and the whole was published as
     * the 'Good News Bible'
     */
    Good_News("GNB", "Good News"),

    /**
     * Version edited by E. Galbiati, A. Penna and P. Rossano, and published by UTET. This version, based on original
     * texts, is rich in notes and has been used as the basis for CEI translation
     */
    Galbiati_Penna_Rossano_UTET("GPR", "Galbiati, Penna, Rossano – UTET"),

    /**
     * (GNT) New Testament text in an original Greek version
     */
    Original_Greek("GRK", "Original Greek"),

    /**
     * Richly annotated 1963 version edited by S. Garofano and S. Rinaldi, and published by Marietti
     */
    Garofano_Rinaldi_Marietti("GRM", "Garofano, Rinaldi – Marietti"),

    /**
     * Old Testament text in an original Hebrew version
     */
    Original_Hebrew("HBR", "Original Hebrew"),

    /**
     * (HCSB, CSB) Published by Broadman and Holman as the Holman Christian Standard Bible (HCSB) in 2004, this
     * translation rejects all forms of gender-neutral wording and is written with strong influences from the Southern
     * Baptist perspective of biblical scholarship. The revised and updated version was first published in 2017 as the
     * Christian Standard Bible (CSB)
     */
    Christian_Standard("HCS", "Christian Standard"),

    /**
     * (ICB) A translation completed in 1986 targeting readability at the US third grade level
     */
    International_Childrens("ICB", "International Children’s"),

    /**
     * (TILC) Interconfessional translation resulting from 1985 effort by Catholic and Protestant scholars, aimed at
     * delivering an easy-to-understand message
     */
    Traduzione_Interconfessionale_in_Lingua_Corrente("ILC", "Traduzione Interconfessionale in Lingua Corrente"),

    /**
     * (JB) A translation designed for English speaking Catholics based on the original languages. It is based on French
     * as well as ancient texts and was first published in 1966. See also code NJR, NJB
     */
    Jerusalem("JER", "Jerusalem"),

    /**
     * (KJV) A translation commissioned by King James I of England and first published in 1611, with revisions in 1769
     */
    King_James("KJV", "King James"),

    /**
     * (KJ21) A verbal translation led by William Prindele. Published in 1994, it was designed to modernize the language
     * of the King James Version based on Webster's New International Dictionary, 2nd edition, unabridged
     */
    _21st_Century_King_James("KJT", "21st Century King James"),

    /**
     * (KJC) 2024 Portuguese translation of the KJV by Editoria Hagnos, preserving the style of the KJV. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    King_James_Classica("KJC", "King James Clássica"),

    /**
     * (TLB) A paraphrase translation led by Kenneth N Taylor and first published in 1972
     */
    Living_Bible("LVB", "Living Bible"),

    /**
     * 1924 translation by Giovanni Luzzi, Professor at the Waldensian Faculty of Theology in Rome, who revised the 17th
     * Century Diodati version
     */
    Luzzi("LZZ", "Luzzi"),

    /**
     * (MSG) A paraphrase translation of the New Testament by Eugene Peterson first published in 1993. Old Testament
     * added by 2002
     */
    Message_Bible("MSG", "Message Bible"),

    /**
     * (NAB) A translation aimed at Catholic readers first published in its entirety in 1970. A revised New Testament
     * was issued in 1986 as the 2nd Edition. The 3rd Edtion was published in 1991 with a revision to Psalms. The 4th
     * Edition (also known as the New American Bible Revised Edition) was published in 2011, incorporating revisions to
     * the Old Testament (prefer code NAR for 4th Edition)
     */
    New_American("NAB", "New American"),

    /**
     * (NABRE) 2011 update (4th Edition) of the New American Bible, with revisions to the Old Testament. Approved by the
     * US Conference of Bishops. Use code NAB for earlier editions. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    New_American_Revised("NAR", "New American Revised"),

    /**
     * (NASB) A translation commissioned by the Lockman Foundation. The New Testament was published in 1960 followed by
     * the entire Bible in 1971. Use code NAU for later revisions
     */
    New_American_Standard("NAS", "New American Standard"),

    /**
     * (NASB-U) A 1995 translation using more modern language than the NASB, with revision in 2020
     */
    New_American_Standard_Updated("NAU", "New American Standard, Updated"),

    /**
     * (CTS NCB) 2007 revision of the 1966 Jerusalem Bible, with new textual and liturgical notes and changes to the
     * Psalms, published by the Catholic Truth Society. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    CTS_New_Catholic_Bible("NCB", "CTS New Catholic Bible"),

    /**
     * (St Joseph NCB). A 2019 translation by the Catholic Book Publishing Company (CBP), marketed as Saint Joseph
     * Editions. The New Testament (2015) and Psalms (2002) originally published under the name New Catholic Version.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    St_Joseph_New_Catholic_Bible("NCJ", "St. Joseph New Catholic Bible"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1895("NBA", "Bibelen 1895"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1930("NBB", "Bibelen 1930"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1938("NBC", "Bibelen 1938"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1978_85("NBD", "Bibelen 1978-85"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1978("NBE", "Bibelen 1978"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1985("NBF", "Bibelen 1985"),

    /**
     * Norwegian Bible translation
     */
    Norsk_Bibel_88("NBG", "Norsk Bibel 88"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_1978_85_rev_2005("NBH", "Bibelen 1978-85/rev. 2005"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_2011("NBI", "Bibelen 2011"),

    /**
     * Norwegian Bible translation. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Norsk_Bibel_88_rev_2007("NBJ", "Norsk Bibel 88/rev. 2007"),

    /**
     * Norwegian Bible translation with commentary. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Fauskanger_2015("NBK", "Fauskanger 2015"),

    /**
     * Norwegian Bible translation, 2024 update of Bibelen 2011. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Bibelen_2011_rev_2024("NBL", "Bibelen 2011/rev. 2024"),

    /**
     * Norwegian Bible translation. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Pollestad_2023("NBP", "Pollestad 2023"),

    /**
     * (NCV) A translation inspired by the International Children's version. First published by World Publishing in 1991
     */
    New_Century("NCV", "New Century"),

    /**
     * (NEB) A translation first issued in 1961 (New Testament) and 1970 (complete Bible) as a result of a proposal at
     * the 1946 General Assembly of the Church of Scotland
     */
    New_English("NEB", "New English"),

    /**
     * Norwegian Bible translation
     */
    Bibelen_Guds_ord("NGO", "Bibelen Guds ord"),

    /**
     * (NIV) A translation underwritten by Biblica (formerly the International Bible Society, and previously the New
     * York Bible Society). The New Testament was published in 1973 followed by the entire Bible in 1978. The NIV text
     * was revised in 1984 and again in 2011
     */
    New_International("NIV", "New International"),

    /**
     * (NIrV) A 1996 translation designed for people with limited literacy in English and based on the NIV
     */
    New_International_Readers("NIR", "New International Reader’s"),

    /**
     * (NJB) A revision of the Jerusalem Bible. First published in 1986. See also code NJR
     */
    New_Jerusalem("NJB", "New Jerusalem"),

    /**
     * (RNJB) 2019 successor to Jerusalem and New Jerusalem Bibles. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    New_Jerusalem_Revised("NJR", "New Jerusalem Revised"),

    /**
     * (NKJV) A version issued by Thomas Nelson Publishers in 1982-83 designed to update the language of the King James
     * Version while maintaining the phrasing and rhythm and using the same sources as its predecessor
     */
    New_King_James("NKJ", "New King James"),

    /**
     * Norwegian 'nynorsk' Bible translation
     */
    Bibelen_nynorsk("NNK", "Bibelen, nynorsk"),

    /**
     * (NLT) A translation sponsored by Tyndale House and first released in 1996. It is considered a revision and
     * updating of the Living Bible
     */
    New_Living("NLV", "New Living"),

    /**
     * (NRSV) A revision of the Revised Standard based on ancient texts but updating language to American usage of the
     * 1980s
     */
    New_Revised_Standard("NRS", "New Revised Standard"),

    /**
     * (NTV) A 2010 Spanish translation from the original Greek and Hebrew, sponsored by Tyndale House
     */
    Nueva_Traduccion_Viviente("NTV", "Nueva Traducción Viviente"),

    /**
     * Nuovissima version - a Catholic-oriented translation in modern Italian, edited by a group including Carlo
     * Martini, Gianfranco Ravasi and Ugo Vanni and first published (in 48 volumes, 1967-1980) by Edizioni San Paolo
     */
    Novissima_Versione_della_Bibbia("NVB", "Novissima Versione della Bibbia"),

    /**
     * (NBD) A 2008 Spanish translation from the original Greek and Hebrew, sponsored by the International Bible
     * Society/Sociedad B&#237;blica Internacional
     */
    Nueva_Biblia_al_Dia("NVD", "Nueva Biblia al Dia"),

    /**
     * (NVI) A Spanish translation underwritten by the International Bible Society
     */
    Nueva_Version_Internacional("NVI", "Nueva Version Internacional"),

    /**
     * (NWT) An English translation published by the Watch Tower Bible and Tract Society. Only for use in ONIX 3.0 or
     * later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    New_World_Translation("NWT", "New World Translation"),

    /**
     * (Phi) An idiomatic translation by J B Phillips, first completed in 1966
     */
    New_Testament_in_Modern_English_Phillips("PHP", "New Testament in Modern English (Phillips)"),

    /**
     * (REB) A 1989 revision of the NEB. A significant effort was made to reduce the British flavor present in the NEB
     */
    Revised_English("REB", "Revised English"),

    /**
     * (RV, ERV) The first major revision of the King James Version, the Revised Version incorporates insights from
     * early manuscripts discovered between 1611 and 1870, and corrects readings in the KJV which nineteenth-century
     * scholarship deemed mistaken. The New Testament was published in 1881, the Old Testament in 1885, and the
     * Apocrypha in 1895
     */
    Revised_Version("REV", "Revised Version"),

    /**
     * (RSV) A translation authorized by the National Council of Churches of Christ in the USA. The New Testament was
     * published in 1946 followed by a complete Protestant canon in 1951
     */
    Revised_Standard("RSV", "Revised Standard"),

    /**
     * (RSV-CE, RSV-2CE) Version of the RSV Catholic canon published 1966, with slight updates in 2006. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Revised_Standard_Catholic("RSC", "Revised Standard Catholic"),

    /**
     * A Spanish translation based on the original texts
     */
    ReinaValera("RVL", "Reina–Valera"),

    /**
     * Swedish Bible translation
     */
    Bibel_2000("SBB", "Bibel 2000"),

    /**
     * Norwegian 'samisk' Bible translation
     */
    Bibelen_samisk("SMK", "Bibelen, samisk"),

    /**
     * (TEV) A translation of the New Testament sponsored by the American Bible Society and first published in 1966. It
     * was incorporated into the 'Good News Bible' (GNB) in 1976
     */
    Todays_English("TEV", "Today’s English"),

    /**
     * (TNIV) An updating of the New International Version. The New Testament was published in 2002, and the entire
     * Bible in 2005. Superseded by the 2011 NIV update
     */
    Todays_New_International("TNI", "Today’s New International"),

    /**
     * (NV) Neo-Vulgate or Nova Vulgata Bibliorum Sacrorum Editio, official Latin translation of the Catholic canon,
     * published 1979 with a revised 2nd edition in 1986. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nova_Vulgata("VUN", "Nova Vulgata"),

    /**
     * (ERV, EVD) Version in contemporary language, originally published as the Bible for the Deaf by Bible League
     * International to facilitate access to the Biblical text. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Easy_to_read_version("ERV", "Easy to read version"),

    /**
     * 2000 Aprobado por el Consejo Episcopal Latinoamericano y Caribe&#241;o (CELAM). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Biblia_de_Jerusalen_Latinoamericana("JEL", "Biblia de Jerusalén Latinoamericana"),

    /**
     * (PER) Esta 1999 edici&#243;n busca reproducir el estilo po&#233;tico en que fue escrita la Biblia, utilizando la
     * traducci&#243;n idiom&#225;tica. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Biblia_do_Peregrino("BDP", "Bíblia do Peregrino"),

    /**
     * (JFA1) Primeira vers&#227;o tradu&#231;&#227;o 1753, publicada originalmente em 2 volumes. Only for use in ONIX
     * 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Joao_Ferreira_de_Almeida_Primeira_Versao("JFA", "João Ferreira de Almeida (Primeira Versão)"),

    /**
     * (JFA2) Revis&#227;o de 1819 publicada originalmente em um &#250;nico volume. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Joao_Ferreira_de_Almeida_Segunda_Versao("JFB", "João Ferreira de Almeida (Segunda Versão)"),

    /**
     * (ARE) Revista em 1840 por E. Whitely. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Emendada("JFC", "Almeida Revista e Emendada"),

    /**
     * (ARR) Revisada em 1847 pela Sociedade B&#237;blica Trinitariana. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Reformada("JFD", "Almeida Revista e Reformada"),

    /**
     * (ARC1) Revis&#227;o de 1875 coordenada pelo portugu&#234;s Jo&#227;o Nunes Chaves
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Correcta("JFE", "Almeida Revista e Correcta"),

    /**
     * (ARC2) Revis&#227;o de 1898 feita em Lisboa, Portugal
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Corrigida_1898("JFF", "Almeida Revista e Corrigida 1898"),

    /**
     * (ARC-SG) Revis&#227;o de 1944 da Imprensa B&#237;blica Brasileira com ajustes ortogr&#225;ficos para facilitar a
     * leitura. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Corrigida_na_Grafia_Simplificada("JFG", "Almeida Revista e Corrigida na Grafia Simplificada"),

    /**
     * (ARC3) Revis&#227;o de 1949 pela Sociedade B&#237;blica do Brasil
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Corrigida_1949("JFH", "Almeida Revista e Corrigida 1949"),

    /**
     * (ARA1) Revis&#227;o e atualiza&#231;&#227;o de 1959 feita pela Sociedade B&#237;blica do Brasil a partir dos
     * manuscritos originais
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Atualizada("JFI", "Almeida Revista e Atualizada"),

    /**
     * (AVR) Revis&#227;o de 1968 faita pela Imprensa B&#237;blica Brasileira a partir dos manuscritos originais. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revisada_de_Acordo_com_os_Melhores_Textos_em_Hebraico_e_Grego("JFJ",
        "Almeida Revisada de Acordo com os Melhores Textos em Hebraico e Grego"),

    /**
     * (ARC4) Segunda revis&#227;o do texto de Almeida ARC3 de 1969 pela Sociedade B&#237;blica do Brasil
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Corrigida_1969("JFK", "Almeida Revista e Corrigida 1969"),

    /**
     * (ARA) Revis&#227;o de 1993 da primeira edi&#231;&#227;o ARA1 que apresenta importantes mudan&#231;as
     * estil&#237;sticas e exeg&#233;ticas. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Atualizada_Segunda_Edicao("JFL", "Almeida Revista e Atualizada, Segunda Edição"),

    /**
     * (ARC) Revis&#227;o de 1995 da primeira edi&#231;&#227;o, feita pela Sociedade B&#237;blica do Brasil. Only for
     * use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Revista_e_Corrigida_Nova_Edicao("JFM", "Almeida Revista e Corrigida, Nova Edição"),

    /**
     * (AEC) Revis&#227;o de 1999 feita pela Editora Vida, livre de arca&#237;smos e ambiguidades, preservando o estilo
     * pr&#243;prio da Almeida Revista e Corrigida. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Edicao_Contemporanea("JFN", "Almeida Edição Contemporânea"),

    /**
     * (AS21) Vers&#227;o de 2008 feita em parceria entre a Imprensa B&#237;blica Brasileira e a Edi&#231;&#245;es Vida
     * Nova, a qual incorporou avan&#231;os na Cr&#237;tica Textual b&#237;blica, possibilitando um avan&#231;o
     * gramatical e ortogr&#225;fico sobre a Almeida Revisada
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Seculo_21("JFO", "Almeida Século 21"),

    /**
     * (ACF1) Revis&#227;o dos textos originais de Almeida, feita em 1994 pela Sociedade B&#237;blica Trinitariana
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Corrigida_e_Fiel_1994("JFP", "Almeida Corrigida e Fiel 1994"),

    /**
     * (ACF) &#218;ltima revis&#227;o feita em 2011 pela Sociedade B&#237;blica Trinitariana. Only for use in ONIX 3.0
     * or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Almeida_Corrigida_e_Fiel_2011("JFQ", "Almeida Corrigida e Fiel 2011"),

    /**
     * (NAA) Revis&#227;o mais aprofundada da Almeida Revista e Atualizada (ARA) feita em 2021 pela Sociedade
     * B&#237;blica do Brasil. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nova_Almeida_Atualizada("JFR", "Nova Almeida Atualizada"),

    /**
     * (TB) Vers&#227;o elaborada por uma comiss&#227;o de especialistas a partir dos originais. &#201; a primeira
     * tradu&#231;&#227;o completa da B&#237;blia feita no Brasil. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Traducao_Brasileira("TBB", "Tradução Brasileira"),

    /**
     * (TLH) Vers&#227;o feita em 1988 diretamente dos originais, adequada para o n&#237;vel educacional m&#233;dio da
     * popula&#231;&#227;o brasileira. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Traducao_na_Linguagem_de_Hoje("TBC", "Tradução na Linguagem de Hoje"),

    /**
     * (NTLH) Revis&#227;o de 2000 da primeira edi&#231;&#227;o da Tradu&#231;&#227;o na Linguagem de Hoje,
     * principalmente sobre o texto do Novo Testamento. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nova_Traducao_na_Linguagem_de_Hoje("TBD", "Nova Tradução na Linguagem de Hoje"),

    /**
     * (NVI) Vers&#227;o de 2001 feita pela B&#237;blica Brasil, a partir dos manuscritos mais aceitos, com equipe de
     * profissionais brasileiros com base na NIV americana. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nova_Versao_Internacional("NVJ", "Nova Versão Internacional"),

    /**
     * Vers&#227;o de 2016 da Tyndale Fundation feita por exegetas brasileiros a partir dos textos originais, tendo como
     * base a New Living Translation norte-americana. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Nova_Versao_Transformadora("NVT", "Nova Versão Transformadora"),

    /**
     * (KJA) Tradu&#231;&#227;o em 2012 para o portugu&#234;s brasileiro moderno da Sociedade B&#237;blica
     * Ibero-Americana do Brasil e da Editora Abba Press da B&#237;blia King James (KJV)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    King_James_Atualizada("KJA", "King James Atualizada"),

    /**
     * (BCNBB) A tradu&#231;&#227;o oficial cat&#243;lica 2018 se baseia nos textos originais hebraicos, aramaicos e
     * gregos, comparados com a Nova Vulgata. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Biblia_Sagrada_Traducao_Oficial_da_CNBB("BCN", "Bíblia Sagrada Tradução Oficial da CNBB"),

    /**
     * (BMD) Tradu&#231;&#227;o da B&#237;blia para portugu&#234;s de 1983 diretamete dos originais hebraicos e gregos,
     * feita pela Liga de Estudos B&#237;blicos. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Biblia_Mensagem_de_Deus("BMD", "Bíblia Mensagem de Deus"),

    /**
     * (TEB) Tradu&#231;&#227;o Ecum&#234;nica baseia-se nos textos originais e reproduz fielmente o modelo da
     * mundialmente reconhecida Traduction Oecum&#233;nique de la Bible. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Traducao_Ecumenica_da_Biblia("TEB", "Tradução Ecumênica da Bíblia"),

    /**
     * 2023 tradu&#231;&#227;o dos textos sagrados feita diretamente das l&#237;nguas originais (hebraico, aramaico e
     * grego) para o portugu&#234;s. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    A_Biblia_Paulinas("PAU", "A Bíblia Paulinas"),

    /**
     * (BAM) Translation from the Greek, Hebrew and Aramaic originals by the Benedictine Monks of Maredsous, best known
     * in the 1959 Brazilian Portuguese translation by Mission&#225;rios do Imaculado Cora&#231;&#227;o de Maria. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Bible_de_Maredsous_Biblia_Ave_Maria("BAM", "Bible de Maredsous (Bíblia Ave-Maria)"),

    /**
     * (TOB) Ecumenical translation of the Bible, a revision of the Jerusalem Bible by both Catholics and Protestants in
     * 1975. Revised in 1988, 2004, and in 2010 with additional books from the Orthodox canon. Only for use in ONIX 3.0
     * or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Traduction_Oecumenique_de_la_Bible("TOB", "Traduction Oecuménique de la Bible"),

    /**
     * Other translations not otherwise noted
     */
    Other("ZZZ", "Other");

    public final String code;
    public final String description;

    BibleVersions(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, BibleVersions> map;

    private static Map<String, BibleVersions> map() {
        Map<String, BibleVersions> result = map;
        if (result == null) {
            synchronized (BibleVersions.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BibleVersions e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BibleVersions byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<BibleVersions> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
