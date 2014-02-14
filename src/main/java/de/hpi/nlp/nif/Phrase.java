package de.hpi.nlp.nif;

import org.apache.commons.codec.digest.DigestUtils;

public class Phrase {

	public String sourceUri;
	public String text;
	public int begin;
	public int end;
	public String entity;
	public Context context;
	
	public String needsValidation;
	
	public Phrase(String sourceUri, String text, int begin, int end, String entity, Context context) {
		this.sourceUri = sourceUri;
		this.text = text;
		this.begin = begin;
		this.end = end;
		this.entity = entity;
		this.context = context;
		this.needsValidation = "";
	}

	public String getUri() {
		return "http://www.yovisto.com/labs/ner-benchmarks/data/" + DigestUtils.md5Hex(sourceUri) + "#char=" + begin +"," + end;
	}

	@Override
	public String toString() {
		String r = "";
		
		if (!needsValidation.isEmpty()) {
			r = r + "-- " + needsValidation + "\n";
		}

		r = r + "<" + getUri() + ">\n" +
				"\ta nif:String , nif:Phrase , nif:RFC5147String ;\n" +
				"\tnif:referenceContext <" + context.getUri() + "> ;\n" +
				"\tnif:anchorOf \"\"\"" + text + "\"\"\"^^xsd:string ;\n" +
				"\tnif:beginIndex \"" + begin + "\"^^xsd:nonNegativeInteger ;\n" +
				"\tnif:endIndex \"" + end + "\"^^xsd:nonNegativeInteger ;\n" +
				"\titsrdf:taIdentRef <" + entity + "> .\n";
		
		return r;
	}
	
	
}
