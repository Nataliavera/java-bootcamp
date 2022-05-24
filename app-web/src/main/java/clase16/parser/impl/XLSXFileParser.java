package clase16.parser.impl;

import clase16.parser.FileBase;
import clase16.parser.IParser;
import clase16.types.XLSX;

public class XLSXFileParser extends FileBase implements IParser<XLSX> {

	public XLSXFileParser(String fileString) {
		super(fileString);
	}

	@Override
	public XLSX parse() {
		return null;
	}

}
