
# Developer's Guide to Deployment
```bash
    mvn -version
```

Make sure your build environment meets the requirements:
- Maven version >= 3.3.9
- JDK version >= 9

## Prepare Maven (One time only)

The deployment process to Sonatype Central Repository is described in <http://central.sonatype.org/pages/apache-maven.html>.

Make sure to have:
- GnuPG installed, and `gpg` in the `PATH`
- register the key `AA4924CB7F77B1AD3BB5BD6D66E9DCBA41C58B92`

To verify:
```bash
    gpg --list-secret-keys
    # if missing: gpg --import <zach-tectonica.gpg
```

Edit `~/.m2/settings.xml`

```xml
    <settings>

      <servers>
        <server>
          <id>ossrh</id>
          <username>zach-m</username>
          <password>JIRA_PASSWORD</password>
        </server>
      </servers>
      
      <profiles>
        <profile>
          <id>ossrh</id>
          <activation>
            <activeByDefault>true</activeByDefault>
          </activation>
          <properties>
            <gpg.executable>gpg</gpg.executable>
            <gpg.passphrase>KEY_PASSPHRASE</gpg.passphrase>
          </properties>
        </profile>
      </profiles>

    </settings>
```

## Set Version for deployment
```bash
    cd /path/to/jonix/home
    mvn -P versioning versions:set -DnewVersion=8.1.0
    # manually set <project.parent.version> in jonix-codegen
```

## Generate aggregated JavaDocs (for online site)
```bash
    cd /path/to/jonix/home
    # mvn clean
    mvn -P release compile javadoc:aggregate
    # ls -l target/site/apidocs
    
    # deploy to https://zach-m.github.io/jonix/
    # git clone -b gh-pages --single-branch https://github.com/zach-m/jonix.git gh-pages
    cd gh-pages
    git pull
    rm -rf $(ls -1)
    cp -r ../target/site/apidocs/* .
    git add -A
    git commit -m 'official documentation for v9.0'
    git push
```

## Deploy JARs

NOTE: due to `maven-javadoc-plugin` this currently works only with [open-jdk-9](https://jdk.java.net/java-se-ri/9).

```bash
    cd /path/to/jonix/home
    # mvn clean
    mvn -P release,java8 install deploy
```