run: compile
	java -jar server.jar

compile:
	kotlinc server.kt -include-runtime -d server.jar
