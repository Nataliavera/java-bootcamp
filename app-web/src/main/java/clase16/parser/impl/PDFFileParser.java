package clase16.parser.impl;

import clase16.parser.FileBase;
import clase16.parser.IParser;
import clase16.types.PDF;

public class PDFFileParser extends FileBase implements IParser<PDF> {

	public PDFFileParser(String fileContent) {
		super(fileContent);
	}

	@Override
	public PDF parse() {
		return null;
	}

}
