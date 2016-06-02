compilar:
	-@find -name "*.java" > sources.txt
	-@javac @sources.txt
	-@rm sources.txt
	-@jar -cfm main.jar MANIFEST.MF -C src/ .
	-@mkdir -p bin
	-@mv main.jar bin/

abrir:
	-@java -jar bin/main.jar

doc:
	-@javadoc -d doc -sourcepath src -subpackages edu.ctpositivo