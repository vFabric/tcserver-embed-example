tcserver-embed-example
======================
<ul>
<li> PURPOSE </li>

To demonstrate the creation and use of a basic embedded tc Runtime instance using the Pivotal Commercial Maven Repository to pull down the tc Server artifacts in a Maven project.

<li>REQUIREMENTS</li>
- Maven 2.2.1 installed

<li>PRE-BUILD</li>
<ol>
  <li> Create your own Pivotal Commercial Maven Repository (vCMR) account at https://commercial-repo.pivotal.io.</li>
  <li> Add/Modify the pom.xml to add a repository as shown below and in the vCMR.</li>
<pre>
<code>
&lt;repository&gt;
	&lt;id&gt;tcserver-release-repo&lt;/id&gt;
	&lt;name&gt;tc Runtime release repository&lt;/name&gt;
	&lt;url&gt;https://commercial-repo.pivotal.io/data3/tcserver-release-repo/tcserver&lt;/url&gt;
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
      &lt;id&gt;tcserver-release-repo&lt;/id&gt;
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
java -jar target/example-0.0.3-SNAPSHOT-jar-with-dependencies.jar 
</code>
  <li>Result</li>
This will startup a self contained tc Runtime instance with a "Hello, World" webapp on port 8080. It will also listen on port 1099 for incoming jmx connections.
</ul>

Additional Documentation
========================

Full tc Server Documentation can me found at https://tcserver.docs.pivotal.io/

More on embedded tc Server can be found at https://tcserver.docs.pivotal.io/docs-tcserver/topics/postinstall-getting-started.html#postinstall-embedding-tc-server
