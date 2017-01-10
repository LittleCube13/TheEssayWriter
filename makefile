all:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class
	rm *.class