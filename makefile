iall:
	make dev
	make clean

dev:
	git submodule init
	git submodule update
	javac *.java
	jar cvfe EssayWriter.jar EssayWriter *

clean:
	rm *.class || continue
	rm leviathanyaml/*.class || continue

clean-all:
	make clean
	rm EssayWriter.jar || continue
