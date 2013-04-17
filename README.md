tcserver-embed-example
======================

* PURPOSE

To demonstrate the creation and use of a basic embedded tc Runtime instance using the vFabric Commercial Maven Repository to pull down the tc Server artifacts in a Maven project.

* REQUIREMENTS
- Maven 2.2.1 installed

* PRE-BUILD
1. Create your own vFabric Commercial Maven Repository (vCMR) account at http://repository.cloudfoundry.com.
2. Add/Modify a repository shown in the located vCMR in the pom.xml.
<pre>
<code>
<repository>
	<id>tcruntime-release</id>
	<name>tc Runtime release repository</name>
	<url>https://repository.cloudfoundry.com/data2/maven/bundles/release</url>
</repository>
</code>
</pre>
3. Add/Modify the ~/.m2/settings.xml to add your username and password for the repository. 
NOTE: Make sure the repository <id> and the server <id> match.
<pre>
<code>
<settings>
  <servers>
  	...
    <server>
      <id>tcruntime-release</id>
      <username>jkonicki@vmware.com</username>
      <password><!-- Insert your decrypted password (which we don't have) --></password>
    </server>
    ...
  </servers>
</settings>
</code>
</pre>
* BUILD
<pre><code>
mvn clean compile assembly:single
</code></pre>

* USAGE
<pre><code>
java -jar target/example-0.0.2-SNAPSHOT-jar-with-dependencies.jar 
</code></pre>

* Result
This will startup a self contained tc Runtime instance with a "Hello, World" webapp on port 8080. It will also listen on port 1099 for incoming jmx connections.

