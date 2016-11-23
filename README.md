# phraseapp-gradle-plugin

This plugin helps you to sync your externalized/internationalized messages with your PharseApp account. So it will be a bridge between you as the developer how created messages keys which need to be translated and the translation agency/translater who will translate this keys.

## Usage
### Configuration
#### 1. Add the plugin artifact to your dependency list in build.gradle

```
    apply plugin: 'de.esailors.gradle.plugins.phraseapp'
    
    phraseAppSettings {
        projectId = "123456789-your-project-id"
        authToken = "987654321-your-auth-token"
    }
    
    buildscript {
        repositories {
            jcenter()
            mavenCentral()
            mavenLocal()
        }
        dependencies {
            classpath 'de.esailors.gradle.plugins:phraseapp-gradle-plugin:1.0.0-SNAPSHOT'
        }
    }
```

#### 2. Execute some task
After you have configured your build.gradle file, simply run: **gradle [taskname]**

<table border="0">
	<tr>
		<th>TaskName</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>download</td>
		<td>Downloads all messages properties from PhraseApp for your configured project.</td>
	</tr>
</table>

#### 3. Possible configurations

<table border="0">
	<tr>
		<th>PropertyName</th>
		<th>Default Value</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>authToken</td>
		<td>*</td>
		<td>The AuthToken you have created in your PhraseApp account to pull/push keys.</td>
	</tr>
	<tr>
    	<td>projectId</td>
    	<td>*</td>
    	<td>The internal PhraseApp project id to identify the messages you will pull/push.</td>
    </tr>
	<tr>
    	<td>destinationDir</td>
    	<td>generated-resources</td>
    	<td>The name of the folder where the {messagesDir} should located.</td>
    </tr>
	<tr>
    	<td>destinationMessagesDir</td>
    	<td>messages</td>
    	<td>The name of the folder where the downloaded messages should be saved.</td>
    </tr>
	<tr>
    	<td>messageFilePrefix</td>
    	<td>messages_</td>
    	<td>The prefix name of the messages files.</td>
    </tr>
	<tr>
    	<td>fileFormat</td>
    	<td>properties</td>
    	<td>The file format you want to download the messages keys.[properties,xml]</td>
    </tr>
</table>
* these properties are required!!!

### Execute Tasks

After you have configured your build.gradle file, simply run: gradle [the-task-you-want-to-execute].


## Dependencies
### Java SDK
* Java 7 or higher

### Runtime
* SLF4J for logging
* Lombok to remove some boilerplate code
* Phrase-Java-Client from [mytaxi](https://github.com/mytaxi) to encapsulate the PhraseApp API
* Spring-Web because the PharseApp-Java-Client needs this -> Bug

### For Unit tests
* JUntit for simple unit tests

## Links
* [PhraseApp API Doku v2](https://phraseapp.com/docs/api/v2)

## FAQ
TODO: ProjectId, AuthToken

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## License

[Apache License, Version 2.0](https://github.com/esailors/phraseapp-gradle-plugin/LICENSE)

## TODOs
* push functionality - push new keys or translation mistakes to phraseApp