tcserver-embed-example
======================
<ul>
<li> PURPOSE </li>

To demonstrate the creation and use of a basic embedded tc Runtime instance using the Pivotal Commercial Maven Repository to pull down the tc Server artifacts in a Maven project.

<li>REQUIREMENTS</li>
- Maven 2.2.1 installed

<li>PRE-BUILD</li>
<ol>
  <li> Create your own Pivotal Commercial Maven Repository (vCMR) account at http://repository.cloudfoundry.com.</li>
  <li> Add/Modify the pom.xml to add a repository as shown below and in the vCMR.</li>
<pre>
<code>
&lt;repository&gt;
	&lt;id&gt;tcruntime-release&lt;/id&gt;
	&lt;name&gt;tc Runtime release repository&lt;/name&gt;
	&lt;url&gt;https://repository.cloudfoundry.com/data2/maven/bundles/release&lt;/url&gt;
&lt;/repository&gt;
</code>
</pre>
  <li> Add/Modify the ~/.m2/settings.xml to add your username and password for the repository. </li>
<br>
NOTE: Make sure the repository &lt;id&gt; and the server &lt;id&gt; match.
<pre>
<code>
&lt;settings&gt;
  &lt;servers&gt;
  	...
    &lt;server&gt;
      &lt;id&gt;tcruntime-release&lt;/id&gt;
      &lt;username&gt;!-- Username --!&lt;/username&gt;
      &lt;password&gt;!-- Insert your decrypted password (which we don't have) --!&lt;/password&gt;
    &lt;/server&gt;
    ...
  &lt;/servers&gt;
&lt;/settings&gt;
</code>
</pre>
</ol>
</ul>
<ul>
  <li>BUILD</li>
<code>
mvn clean compile assembly:single
</code>
  <li>USAGE</li>
<code>
java -jar target/example-0.0.2-SNAPSHOT-jar-with-dependencies.jar 
</code>
  <li>Result</li>
This will startup a self contained tc Runtime instance with a "Hello, World" webapp on port 8080. It will also listen on port 1099 for incoming jmx connections.
</ul>
