all:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class
	rm *.class || continue

dev:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *.class

clean:
	rm *.class || continue

clean-all:
	make clean
	rm *.jar || continue