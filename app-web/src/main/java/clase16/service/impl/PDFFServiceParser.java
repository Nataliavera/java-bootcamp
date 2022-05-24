package clase16.service.impl;

import clase16.parser.IParser;
import clase16.parser.impl.PDFFileParser;
import clase16.service.FileService;
import clase16.types.PDF;

public class PDFFServiceParser implements FileService {

	private IParser<PDF> parser;

	public PDFFServiceParser(String file) {
		super();
		this.parser = new PDFFileParser(file);
	}


	@Override
	public boolean validar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
