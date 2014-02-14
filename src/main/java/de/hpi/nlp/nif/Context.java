package de.hpi.nlp.nif;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;

public class Context {

	private static Logger L = Logger.getLogger(Context.class.getSimpleName());
	
	public String sourceUri;
	public String text;
	public int begin;
	public int end;
	public Context broaderContext;
	public List<Context> narrowerContexts;
	public List<Phrase> references;
	
	public Context(String sourceUri, String text, int begin, int end) {
		this.sourceUri = sourceUri;
		this.text = text;
		this.begin = begin;
		this.end = end;
		
		this.narrowerContexts = new ArrayList<Context>();
		this.references = new ArrayList<Phrase>();
	}

	@Override
	public String toString() {
		String r = "<" + getUri() + ">\n";
		
		if (broaderContext == null) {
			r = r + "\ta nif:String , nif:Context , nif:Paragraph , nif:RFC5147String ;\n";
		} else {
			r = r + "\ta nif:String , nif:Context , nif:Sentence , nif:RFC5147String ;\n";
		}
		r = r + "\tnif:isString \"\"\"" + text + "\"\"\"^^xsd:string ;\n";
		if (broaderContext == null) {
			r = r + "\tnif:sourceUrl <" + sourceUri + "> .\n";
		} else {
			r = r + "\tnif:broaderContext <" + broaderContext.getUri() + "> .\n";
		}
		for (Context n : narrowerContexts) {
			r = r + "\n" + n.toString();
		}
		for (Phrase p : references) {
			r = r + "\n" + p.toString();
		}
		return r;
	}

	public String getUri() {
		return "http://www.yovisto.com/labs/ner-benchmarks/data/" + DigestUtils.md5Hex(sourceUri) + "#char=" + begin +"," + end;
	}

	public void addNarrower(Context narrower) {
		narrowerContexts.add(narrower);		
		narrower.broaderContext = this;
	}
	
	public void addPhrase(Phrase reference) {
		references.add(reference);
	}

	public Context getNarrower(int begin, int end) {
		for (Context c : narrowerContexts) {
			if (c.begin <= begin && c.end >= end)
				return c;
		}
		
		L.warning("No narrower context found for [" + begin + "," + end +"].");
		return this;
	}
}
