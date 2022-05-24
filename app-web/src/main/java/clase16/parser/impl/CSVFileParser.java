package clase16.parser.impl;

import clase16.parser.FileBase;
import clase16.parser.IParser;
import clase16.types.CSV;

public class CSVFileParser extends FileBase implements IParser<CSV> {

	public CSVFileParser(String fileString){
		super(fileString);
	}
	
	@Override
	public CSV parse() {
//		LOGICA DE PARSEO
		return null;
	}

}
