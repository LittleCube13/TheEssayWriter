all: submodule dev clean

offline: dev

dev:
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *

submodule:
	git submodule init
	git submodule update

clean:
	rm *.class || continue
	rm leviathanyaml/*.class || continue

clean-all:
	make clean
	rm EssayWriter.jar || continue
