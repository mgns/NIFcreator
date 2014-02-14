package de.hpi.nlp.nif;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

/**
 * Simple NIF creator to produce a NIF for the DBpedia Spotlight Dataset.
 * Results need to be validated / post-processed manually.
 * 
 * Results can be found at http://www.yovisto.com/labs/ner-benchmarks/
 * 
 * @author magnus
 */
public class NIFcreator {

	private static Logger L = Logger.getLogger(NIFcreator.class.getSimpleName());

	// URI -> text
	Map<String, Context> mainContexts;

	// surfaceform -> URI
	Map<String, String> references;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NIFcreator creator = new NIFcreator();

		// TODO load texts/paragraphs/sentences from file
		creator.addText("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "Worries over Internet privacy have spurred lawsuits, conspiracy theories and consumer anxiety as marketers and others invent new ways to track computer users on the Internet. But the alarmists have not seen anything yet. In the next few years, a powerful new suite of capabilities will become available to Web developers that could give marketers and advertisers access to many more details about computer users’ online activities. Nearly everyone who uses the Internet will face the privacy risks that come with those capabilities, which are an integral part of the Web language that will soon power the Internet: HTML 5. The new Web code, the fifth version of Hypertext Markup Language used to create Web pages, is already in limited use, and it promises to usher in a new era of Internet browsing within the next few years. It will make it easier for users to view multimedia content without downloading extra software; check e-mail offline; or find a favorite restaurant or shop on a smartphone.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "Worries over Internet privacy have spurred lawsuits, conspiracy theories and consumer anxiety as marketers and others invent new ways to track computer users on the Internet.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "But the alarmists have not seen anything yet.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "In the next few years, a powerful new suite of capabilities will become available to Web developers that could give marketers and advertisers access to many more details about computer users’ online activities.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "Nearly everyone who uses the Internet will face the privacy risks that come with those capabilities, which are an integral part of the Web language that will soon power the Internet: HTML 5.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "The new Web code, the fifth version of Hypertext Markup Language used to create Web pages, is already in limited use, and it promises to usher in a new era of Internet browsing within the next few years.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/media/11privacy.html", "It will make it easier for users to view multimedia content without downloading extra software; check e-mail offline; or find a favorite restaurant or shop on a smartphone.");

		creator.addText("http://www.nytimes.com/2010/10/11/sports/basketball/11nets.html", "The Nets dropped into Moscow on Sunday for a one-day visit meant to raise their profile in the home country of their new owner, the Russian billionaire Mikhail D. Prokhorov. “Welcome to Russia,” Prokhorov said as he greeted his players during their first trip to a country he hopes will become a kind of second home for the team — as well as a source of wealthy sponsors. The stay was just long enough for a little practice and an exhibition in which the Nets were interspersed on the court with top players from youth leagues across Russia — some as young as 8 years old — for a light-hearted game in the arena of CSKA Moscow, the professional Russian club Prokhorov once owned. Prokhorov said the visit would serve as a cornerstone for future interaction between players and coaches from the Nets and young Russians, with the aim of developing basketball in Russia, where the sport is a distant third in popularity behind soccer and hockey. If the Nets pick up a strong Russian fan base in the process, that would be nice, too, he said.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/sports/basketball/11nets.html", "The Nets dropped into Moscow on Sunday for a one-day visit meant to raise their profile in the home country of their new owner, the Russian billionaire Mikhail D. Prokhorov.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/sports/basketball/11nets.html", "“Welcome to Russia,” Prokhorov said as he greeted his players during their first trip to a country he hopes will become a kind of second home for the team — as well as a source of wealthy sponsors.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/sports/basketball/11nets.html", "The stay was just long enough for a little practice and an exhibition in which the Nets were interspersed on the court with top players from youth leagues across Russia — some as young as 8 years old — for a light-hearted game in the arena of CSKA Moscow, the professional Russian club Prokhorov once owned.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/sports/basketball/11nets.html", "Prokhorov said the visit would serve as a cornerstone for future interaction between players and coaches from the Nets and young Russians, with the aim of developing basketball in Russia, where the sport is a distant third in popularity behind soccer and hockey.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/sports/basketball/11nets.html", "If the Nets pick up a strong Russian fan base in the process, that would be nice, too, he said.");

		creator.addText("http://www.nytimes.com/2010/10/10/us/10pot.html", "To the rites of middle-age passage, some families are adding another: buying marijuana for aging parents. Bryan, 46, a writer who lives in Illinois, began supplying his parents about five years ago, after he told them about his own marijuana use. When he was growing up, he said, his parents were very strict about illegal drugs. “We would have grounded him,” said his mother, who is 72. But with age and the growing acceptance of medical marijuana, his parents were curious. His father had a heart ailment, his mother had dizzy spells and nausea, and both were worried about Alzheimer’s disease and cancer. They looked at some research and decided marijuana was worth a try.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "To the rites of middle-age passage, some families are adding another: buying marijuana for aging parents.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "Bryan, 46, a writer who lives in Illinois, began supplying his parents about five years ago, after he told them about his own marijuana use.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "When he was growing up, he said, his parents were very strict about illegal drugs.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "“We would have grounded him,” said his mother, who is 72.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "But with age and the growing acceptance of medical marijuana, his parents were curious.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "His father had a heart ailment, his mother had dizzy spells and nausea, and both were worried about Alzheimer’s disease and cancer.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/us/10pot.html", "They looked at some research and decided marijuana was worth a try.");

		creator.addText("http://www.nytimes.com/2010/10/10/science/10google.html", "Anyone driving the twists of Highway 1 between San Francisco and Los Angeles recently may have glimpsed a Toyota Prius with a curious funnel-like cylinder on the roof. Harder to notice was that the person at the wheel was not actually driving. The car is a project of Google, which has been working in secret but in plain view on vehicles that can drive themselves, using artificial-intelligence software that can sense anything near the car and mimic the decisions made by a human driver. With someone behind the wheel to take control if something goes awry and a technician in the passenger seat to monitor the navigation system, seven test cars have driven 1,000 miles without human intervention and more than 140,000 miles with only occasional human control. One even drove itself down Lombard Street in San Francisco, one of the steepest and curviest streets in the nation. The only accident, engineers said, was when one Google car was rear-ended while stopped at a traffic light.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/science/10google.html", "Anyone driving the twists of Highway 1 between San Francisco and Los Angeles recently may have glimpsed a Toyota Prius with a curious funnel-like cylinder on the roof.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/science/10google.html", "Harder to notice was that the person at the wheel was not actually driving.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/science/10google.html", "The car is a project of Google, which has been working in secret but in plain view on vehicles that can drive themselves, using artificial-intelligence software that can sense anything near the car and mimic the decisions made by a human driver.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/science/10google.html", "With someone behind the wheel to take control if something goes awry and a technician in the passenger seat to monitor the navigation system, seven test cars have driven 1,000 miles without human intervention and more than 140,000 miles with only occasional human control.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/science/10google.html", "One even drove itself down Lombard Street in San Francisco, one of the steepest and curviest streets in the nation.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/science/10google.html", "The only accident, engineers said, was when one Google car was rear-ended while stopped at a traffic light.");

		creator.addText("http://www.nytimes.com/2010/10/11/business/economy/11currency.html", "At a private dinner on Friday at the Canadian Embassy, finance officials from seven world economic powers focused on the most vexing international economic problem facing the Obama administration. Over seared scallops and beef tenderloin, Treasury Secretary Timothy F. Geithner urged his counterparts from Europe, Canada and Japan to help persuade China to let its currency, the renminbi, rise in value — a crucial element in redressing the trade imbalances that are threatening recovery around the world. But the next afternoon, the annual meetings of the International Monetary Fund ended with a tepid statement that made only fleeting and indirect references to the simmering currency tensions.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/economy/11currency.html", "At a private dinner on Friday at the Canadian Embassy, finance officials from seven world economic powers focused on the most vexing international economic problem facing the Obama administration.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/economy/11currency.html", "Over seared scallops and beef tenderloin, Treasury Secretary Timothy F. Geithner urged his counterparts from Europe, Canada and Japan to help persuade China to let its currency, the renminbi, rise in value — a crucial element in redressing the trade imbalances that are threatening recovery around the world.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/business/economy/11currency.html", "But the next afternoon, the annual meetings of the International Monetary Fund ended with a tepid statement that made only fleeting and indirect references to the simmering currency tensions.");

		creator.addText("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "Boilerplate is safe box office, and we’ve gotten our share lately. So it’s great that the Guggenheim Museum is giving us the opposite in its major fall exhibition, “Chaos and Classicism: Art in France, Italy, and Germany, 1918-1936.” With its high percentage of unfamiliar names, the exhibition won’t pull crowds. Visitors with a stake in art-as-uplift will find the story it tells mystifying, if not perverse. I found the whole thing totally engrossing: a survey-style piece of investigative history with a bomb ticking away inside. Its narrative goes something like this: After the exhausting nightmare of World War I, Europe’s early modernist vanguard backed away from disruptive experimental styles like Cubism and Futurism. They retreated to traditional forms and looked back to an imagined classical past — ancient Greece, the Italian Renaissance — for images of wholeness and harmony. To some degree recuperative conservatism worked; it gave artists a way to keep moving when an old way seemed blocked. At the same time classicism as an ideology, with its emphasis on order, purity and exclusion, was being espoused by rising political figures intent on creating a new, lethally exclusionary social order.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "Boilerplate is safe box office, and we’ve gotten our share lately.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "So it’s great that the Guggenheim Museum is giving us the opposite in its major fall exhibition, “Chaos and Classicism: Art in France, Italy, and Germany, 1918-1936.”");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "With its high percentage of unfamiliar names, the exhibition won’t pull crowds.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "Visitors with a stake in art-as-uplift will find the story it tells mystifying, if not perverse.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "I found the whole thing totally engrossing: a survey-style piece of investigative history with a bomb ticking away inside.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "Its narrative goes something like this: After the exhausting nightmare of World War I, Europe’s early modernist vanguard backed away from disruptive experimental styles like Cubism and Futurism.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "They retreated to traditional forms and looked back to an imagined classical past — ancient Greece, the Italian Renaissance — for images of wholeness and harmony.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "To some degree recuperative conservatism worked; it gave artists a way to keep moving when an old way seemed blocked.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/design/11chaos.html", "At the same time classicism as an ideology, with its emphasis on order, purity and exclusion, was being espoused by rising political figures intent on creating a new, lethally exclusionary social order.");

		creator.addText("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "Lil Wayne’s least interesting mode is fixation. Restless and free-associative, he’s best when bouncing from one idea to the next, sticking around just long enough to master it, then splitting before boredom or self-consciousness sets in. “Rebirth,” the last album he released before he began serving a one-year jail sentence at Rikers Island, was his quixotic attempt at a rap-rock album, an out-of-date idea that he treated like aggressive scientific research. It failed less for its experimentation, which was spotty, than for the strenuousness with which he pursued it. From somewhere among those recording sessions, and those rumored to be slated for “Tha Carter IV,” his next album, came the songs found on “I Am Not a Human Being,” an uncentered collection of odds and ends meant to sate interest until Lil Wayne’s release from Rikers, which is expected to be early next month. (He was jailed on a gun-possession charge.) In a sense it’s an improvement on “Rebirth,” even if a couple of the songs bear the scars of that period, particularly the Rick Rubinesque title track, and “Popular,” which has some of the new wave sizzle he was toying with.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "Lil Wayne’s least interesting mode is fixation.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "Restless and free-associative, he’s best when bouncing from one idea to the next, sticking around just long enough to master it, then splitting before boredom or self-consciousness sets in.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "“Rebirth,” the last album he released before he began serving a one-year jail sentence at Rikers Island, was his quixotic attempt at a rap-rock album, an out-of-date idea that he treated like aggressive scientific research.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "It failed less for its experimentation, which was spotty, than for the strenuousness with which he pursued it.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "From somewhere among those recording sessions, and those rumored to be slated for “Tha Carter IV,” his next album, came the songs found on “I Am Not a Human Being,” an uncentered collection of odds and ends meant to sate interest until Lil Wayne’s release from Rikers, which is expected to be early next month.");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "(He was jailed on a gun-possession charge.)");
		creator.addSentence("http://www.nytimes.com/2010/10/11/arts/music/11choice.html", "In a sense it’s an improvement on “Rebirth,” even if a couple of the songs bear the scars of that period, particularly the Rick Rubinesque title track, and “Popular,” which has some of the new wave sizzle he was toying with.");

		creator.addText("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "The short, bearded man in the tutu wanders onstage, an accordion strapped to his back like a rucksack. A tall dancer feigns clumsiness with a slyly graceful gawkiness that would do Buster Keaton proud, stumbling around a ladder and a chair to the delight of the audience. Sasha Waltz & Guests (pictured), named for its choreographer, is the house dance ensemble at Radialsystem V (Holzmarktstr, 33; radialsystem.de), a performance space that opened in 2006 in an old brick Gothic pumping station on the Spree River in Berlin. Even though Berliners know about the dance troupe, visitors often miss its frequently sold-out performances in the towering space of the former machine hall and boiler room of the pumping station. Radialsystem V, miles away from the German capital’s grand boulevard of Unter den Linden, is surrounded by a cluster of gritty nightclubs near the Ostbahnhof train station. During warmer months, a casual passer-by without a ticket to the night’s performance can enjoy a cappuccino with the dance aficionados on the waterfront terrace, but the main draw is the celebrated Ms. Waltz and her dancers, interlocked in twisted, shifting embraces.");
		creator.addSentence("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "The short, bearded man in the tutu wanders onstage, an accordion strapped to his back like a rucksack.");
		creator.addSentence("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "A tall dancer feigns clumsiness with a slyly graceful gawkiness that would do Buster Keaton proud, stumbling around a ladder and a chair to the delight of the audience.");
		creator.addSentence("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "Sasha Waltz & Guests (pictured), named for its choreographer, is the house dance ensemble at Radialsystem V (Holzmarktstr, 33; radialsystem.de), a performance space that opened in 2006 in an old brick Gothic pumping station on the Spree River in Berlin.");
		creator.addSentence("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "Even though Berliners know about the dance troupe, visitors often miss its frequently sold-out performances in the towering space of the former machine hall and boiler room of the pumping station.");
		creator.addSentence("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "Radialsystem V, miles away from the German capital’s grand boulevard of Unter den Linden, is surrounded by a cluster of gritty nightclubs near the Ostbahnhof train station.");
		creator.addSentence("http://www.nytimes.com/interactive/2010/10/10/travel/20101010-OFFBEATCULTURE-INTERACTIVE.html", "During warmer months, a casual passer-by without a ticket to the night’s performance can enjoy a cappuccino with the dance aficionados on the waterfront terrace, but the main draw is the celebrated Ms. Waltz and her dancers, interlocked in twisted, shifting embraces.");

		creator.addText("http://travel.nytimes.com/2010/10/10/travel/10Turku.html", "“LIFE ON A LEAF,” a whimsical yellow house that sits in a wooded park at the edge of Turku in southern Finland, is a lopsided construction with a bright red, blue and green roof and a leaf-shaped floor plan. Inside, it’s even wackier: curved walls, windows in the shape of teardrops, and a catwalk with a tiny video screen embedded in the floor that shows an endless loop of antlike commuters rushing through Grand Central Terminal in New York. On an unseasonably warm September morning I traveled to the Leaf house, which has become something of a local landmark, passing Turku’s harbor overlooked by pine-forested hills, then turning into a clearing in the woods. Jan-Erik Andersson — the artist, sculptor and interior designer who, with contributions from 20 other artists, created the place, and gives tours to groups of visitors who make arrangements in advance — was waiting for me. On the front lawn we lingered in front of his work-in-progress: a fiberglass sauna shaped like a garlic clove, one of five Finnish bathhouses that will be on display in SaunaLab, an exhibition at Turku 2011, the coming yearlong culture festival.");
		creator.addSentence("http://travel.nytimes.com/2010/10/10/travel/10Turku.html", "“LIFE ON A LEAF,” a whimsical yellow house that sits in a wooded park at the edge of Turku in southern Finland, is a lopsided construction with a bright red, blue and green roof and a leaf-shaped floor plan.");
		creator.addSentence("http://travel.nytimes.com/2010/10/10/travel/10Turku.html", "Inside, it’s even wackier: curved walls, windows in the shape of teardrops, and a catwalk with a tiny video screen embedded in the floor that shows an endless loop of antlike commuters rushing through Grand Central Terminal in New York.");
		creator.addSentence("http://travel.nytimes.com/2010/10/10/travel/10Turku.html", "On an unseasonably warm September morning I traveled to the Leaf house, which has become something of a local landmark, passing Turku’s harbor overlooked by pine-forested hills, then turning into a clearing in the woods.");
		creator.addSentence("http://travel.nytimes.com/2010/10/10/travel/10Turku.html", "Jan-Erik Andersson — the artist, sculptor and interior designer who, with contributions from 20 other artists, created the place, and gives tours to groups of visitors who make arrangements in advance — was waiting for me.");
		creator.addSentence("http://travel.nytimes.com/2010/10/10/travel/10Turku.html", "On the front lawn we lingered in front of his work-in-progress: a fiberglass sauna shaped like a garlic clove, one of five Finnish bathhouses that will be on display in SaunaLab, an exhibition at Turku 2011, the coming yearlong culture festival.");

		creator.addText("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "“IF you can’t say something good about someone, sit right here by me,” Alice Roosevelt Longworth, a self-proclaimed “hedonist,” used to say. But it seems the greater pleasure comes from more temperate gossip. New research finds that gossiping can be good for you — as long as you have something nice to say. In a presentation in September, Jennifer Cole, a social psychologist, and Hannah Scrivener reported results from two related studies, both of which demonstrate that it’s in one’s self-interest to say “So-and-so’s second husband is adorable” rather than “She married that lout?” In the first study, intended to measure a person’s short-term emotional reaction to gossiping, 140 men and women, primarily undergraduates, were asked to talk about a fictional person either positively or negatively. The second study, which looked into the long-term effects of gossiping on well-being, had 160 participants, mostly female undergrads, fill out questionnaires about their tendency to gossip, their self-esteem and their perceived social support.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "“IF you can’t say something good about someone, sit right here by me,” Alice Roosevelt Longworth, a self-proclaimed “hedonist,” used to say.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "But it seems the greater pleasure comes from more temperate gossip.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "New research finds that gossiping can be good for you — as long as you have something nice to say.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "In a presentation in September, Jennifer Cole, a social psychologist, and Hannah Scrivener reported results from two related studies, both of which demonstrate that it’s in one’s self-interest to say “So-and-so’s second husband is adorable” rather than “She married that lout?”");
		creator.addSentence("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "In the first study, intended to measure a person’s short-term emotional reaction to gossiping, 140 men and women, primarily undergraduates, were asked to talk about a fictional person either positively or negatively.");
		creator.addSentence("http://www.nytimes.com/2010/10/10/fashion/10Studied.html", "The second study, which looked into the long-term effects of gossiping on well-being, had 160 participants, mostly female undergrads, fill out questionnaires about their tendency to gossip, their self-esteem and their perceived social support.");
		
		// TODO load surfaceform - uri mapping from file

		creator.addReference("http://dbpedia.org/resource/2006", "2006");
		creator.addReference("http://dbpedia.org/resource/2011", "2011");
		creator.addReference("http://dbpedia.org/resource/Accident", "accident");
		creator.addReference("http://dbpedia.org/resource/Accordion", "accordion");
		creator.addReference("http://dbpedia.org/resource/Advertising", "advertisers");
		creator.addReference("http://dbpedia.org/resource/Aggression", "aggressive");
		creator.addReference("http://dbpedia.org/resource/Alarmism", "alarmists");
		creator.addReference("http://dbpedia.org/resource/Album", "album");
		creator.addReference("http://dbpedia.org/resource/Alice_Roosevelt_Longworth", "Alice Roosevelt Longworth");
		creator.addReference("http://dbpedia.org/resource/Alzheimer’s_disease", "Alzheimer’s disease");
		creator.addReference("http://dbpedia.org/resource/Ancient_Greece", "ancient Greece");
		creator.addReference("http://dbpedia.org/resource/Annual_Meetings_of_the_International_Monetary_Fund_and_the_World_Bank_Group", "annual meetings of the International Monetary Fund");
		creator.addReference("http://dbpedia.org/resource/Anxiety", "anxiety");
		creator.addReference("http://dbpedia.org/resource/Art", "Art");
		creator.addReference("http://dbpedia.org/resource/Art_exhibition", "exhibition");
		creator.addReference("http://dbpedia.org/resource/Artificial_intelligence", "artificial-intelligence");
		creator.addReference("http://dbpedia.org/resource/Artist", "artist");
		creator.addReference("http://dbpedia.org/resource/Artist", "artists");
		creator.addReference("http://dbpedia.org/resource/Association_football", "soccer");
		creator.addReference("http://dbpedia.org/resource/Audience", "audience");
		creator.addReference("http://dbpedia.org/resource/Automobile", "car");
		creator.addReference("http://dbpedia.org/resource/Automobile", "cars");
		creator.addReference("http://dbpedia.org/resource/Autumn", "fall");
		creator.addReference("http://dbpedia.org/resource/Backpack", "rucksack");
		creator.addReference("http://dbpedia.org/resource/Balance_of_trade", "trade imbalances");
		creator.addReference("http://dbpedia.org/resource/Ballet_tutu", "tutu");
		creator.addReference("http://dbpedia.org/resource/Basketball", "basketball");
		creator.addReference("http://dbpedia.org/resource/Basketball_court", "court");
		creator.addReference("http://dbpedia.org/resource/Beef_tenderloin", "beef tenderloin");
		creator.addReference("http://dbpedia.org/resource/Berlin", "Berlin");
		creator.addReference("http://dbpedia.org/resource/Berlin", "German capital");
		creator.addReference("http://dbpedia.org/resource/Berlin_Ostbahnhof", "Ostbahnhof");
		creator.addReference("http://dbpedia.org/resource/Billionaire", "billionaire");
		creator.addReference("http://dbpedia.org/resource/Blue", "blue");
		creator.addReference("http://dbpedia.org/resource/Boiler", "boiler");
		creator.addReference("http://dbpedia.org/resource/Boredom", "boredom");
		creator.addReference("http://dbpedia.org/resource/Boulevard", "boulevard");
		creator.addReference("http://dbpedia.org/resource/Box_office", "box office");
		creator.addReference("http://dbpedia.org/resource/Brick", "brick");
		creator.addReference("http://dbpedia.org/resource/Buster_Keaton", "Buster Keaton");
		creator.addReference("http://dbpedia.org/resource/California_State_Route_1", "Highway 1");
		creator.addReference("http://dbpedia.org/resource/Canada", "Canada");
		creator.addReference("http://dbpedia.org/resource/Canadian", "Canadian");
		creator.addReference("http://dbpedia.org/resource/Cancer", "cancer");
		creator.addReference("http://dbpedia.org/resource/Cannabis_(drug)", "marijuana");
		creator.addReference("http://dbpedia.org/resource/Cappuccino", "cappuccino");
		creator.addReference("http://dbpedia.org/resource/Chair", "chair");
		creator.addReference("http://dbpedia.org/resource/Chaos", "Chaos");
		creator.addReference("http://dbpedia.org/resource/Choreography", "choreographer");
		creator.addReference("http://dbpedia.org/resource/Classicism", "Classicism");
		creator.addReference("http://dbpedia.org/resource/Coach_(sport)", "coaches");
		creator.addReference("http://dbpedia.org/resource/Commuting", "commuters");
		creator.addReference("http://dbpedia.org/resource/Computer_software", "software");
		creator.addReference("http://dbpedia.org/resource/Conservatism", "conservatism");
		creator.addReference("http://dbpedia.org/resource/Conspiracy_theory", "conspiracy theories");
		creator.addReference("http://dbpedia.org/resource/Consumer", "consumer");
		creator.addReference("http://dbpedia.org/resource/Content_(media)", "content");
		creator.addReference("http://dbpedia.org/resource/Country", "country");
		creator.addReference("http://dbpedia.org/resource/Criminal_charge", "charge");
		creator.addReference("http://dbpedia.org/resource/CSKA_Universal_Sports_Hall", "arena of CSKA Moscow");
		creator.addReference("http://dbpedia.org/resource/Cubism", "Cubism");
		creator.addReference("http://dbpedia.org/resource/Culture", "culture");
		creator.addReference("http://dbpedia.org/resource/Currency", "currency");
		creator.addReference("http://dbpedia.org/resource/Curve", "curved");
		creator.addReference("http://dbpedia.org/resource/Dance", "dance");
		creator.addReference("http://dbpedia.org/resource/Dance_troupe", "dance troupe");
		creator.addReference("http://dbpedia.org/resource/Dinner", "dinner");
		creator.addReference("http://dbpedia.org/resource/Diplomatic_mission", "Embassy");
		creator.addReference("http://dbpedia.org/resource/Driverless_car", "vehicles that can drive themselves");
		creator.addReference("http://dbpedia.org/resource/Driving", "driving");
		creator.addReference("http://dbpedia.org/resource/Drop_(liquid)", "teardrops");
		creator.addReference("http://dbpedia.org/resource/Economy", "economic");
		creator.addReference("http://dbpedia.org/resource/Email", "e-mail");
		creator.addReference("http://dbpedia.org/resource/Emotion", "emotional");
		creator.addReference("http://dbpedia.org/resource/Engineer", "engineers");
		creator.addReference("http://dbpedia.org/resource/Era", "era");
		creator.addReference("http://dbpedia.org/resource/Europe", "Europe");
		creator.addReference("http://dbpedia.org/resource/Exhibition", "exhibition");
		creator.addReference("http://dbpedia.org/resource/Exhibition_game", "exhibition");
		creator.addReference("http://dbpedia.org/resource/Experiment", "experimentation");
		creator.addReference("http://dbpedia.org/resource/Experiment", "experimental");
		creator.addReference("http://dbpedia.org/resource/Family", "families");
		creator.addReference("http://dbpedia.org/resource/Fan_(person)", "fan");
		creator.addReference("http://dbpedia.org/resource/Father", "father");
		creator.addReference("http://dbpedia.org/resource/Female", "female");
		creator.addReference("http://dbpedia.org/resource/Festival", "festival");
		creator.addReference("http://dbpedia.org/resource/Fiberglass", "fiberglass");
		creator.addReference("http://dbpedia.org/resource/Fiction", "fictional");
		creator.addReference("http://dbpedia.org/resource/Finland", "Finland");
		creator.addReference("http://dbpedia.org/resource/Finnish_sauna", "Finnish bathhouses");
		creator.addReference("http://dbpedia.org/resource/Floor", "floor");
		creator.addReference("http://dbpedia.org/resource/Floor_plan", "floor plan");
		creator.addReference("http://dbpedia.org/resource/France", "France");
		creator.addReference("http://dbpedia.org/resource/Free_association_(psychology)", "free-associative");
		creator.addReference("http://dbpedia.org/resource/Friday", "Friday");
		creator.addReference("http://dbpedia.org/resource/Future", "future");
		creator.addReference("http://dbpedia.org/resource/Futurism", "Futurism");
		creator.addReference("http://dbpedia.org/resource/Game", "game");
		creator.addReference("http://dbpedia.org/resource/Garlic", "garlic");
		creator.addReference("http://dbpedia.org/resource/Germany", "Germany");
		creator.addReference("http://dbpedia.org/resource/Google", "Google");
		creator.addReference("http://dbpedia.org/resource/Google_driverless_car", "Google car");
		creator.addReference("http://dbpedia.org/resource/Gossip", "gossip");
		creator.addReference("http://dbpedia.org/resource/Gossip", "gossiping");
		creator.addReference("http://dbpedia.org/resource/Gothic_architecture", "Gothic");
		creator.addReference("http://dbpedia.org/resource/Grand_Central_Terminal", "Grand Central Terminal");
		creator.addReference("http://dbpedia.org/resource/Green", "green");
		creator.addReference("http://dbpedia.org/resource/Greeting", "greeted");
		creator.addReference("http://dbpedia.org/resource/Grounding_(punishment)", "grounded");
		creator.addReference("http://dbpedia.org/resource/Gun_politics", "gun-possession");
		creator.addReference("http://dbpedia.org/resource/Hall", "hall");
		creator.addReference("http://dbpedia.org/resource/Heart_disease", "heart ailment");
		creator.addReference("http://dbpedia.org/resource/Hedonism", "hedonist");
		creator.addReference("http://dbpedia.org/resource/History", "history");
		creator.addReference("http://dbpedia.org/resource/Hockey", "hockey");
		creator.addReference("http://dbpedia.org/resource/Home", "home");
		creator.addReference("http://dbpedia.org/resource/House", "house");
		creator.addReference("http://dbpedia.org/resource/House_dance", "house dance");
		creator.addReference("http://dbpedia.org/resource/HTML", "Hypertext Markup Language");
		creator.addReference("http://dbpedia.org/resource/HTML5", "HTML 5");
		creator.addReference("http://dbpedia.org/resource/Human", "human");
		creator.addReference("http://dbpedia.org/resource/Husband", "husband");
		creator.addReference("http://dbpedia.org/resource/I_Am_Not_a_Human_Being", "I Am Not a Human Being");
		creator.addReference("http://dbpedia.org/resource/Idea", "idea");
		creator.addReference("http://dbpedia.org/resource/Ideology", "ideology");
		creator.addReference("http://dbpedia.org/resource/Illegal_drug_trade", "illegal drugs");
		creator.addReference("http://dbpedia.org/resource/Illegal_drug_trade", "supplying");
		creator.addReference("http://dbpedia.org/resource/Illinois", "Illinois");
		creator.addReference("http://dbpedia.org/resource/Information_privacy", "privacy");
		creator.addReference("http://dbpedia.org/resource/Interaction", "interaction");
		creator.addReference("http://dbpedia.org/resource/Interior_design", "interior designer");
		creator.addReference("http://dbpedia.org/resource/International", "international");
		creator.addReference("http://dbpedia.org/resource/Internet", "Internet");
		creator.addReference("http://dbpedia.org/resource/Internet_privacy", "Internet privacy");
		creator.addReference("http://dbpedia.org/resource/Italian_Renaissance", "Italian Renaissance");
		creator.addReference("http://dbpedia.org/resource/Italy", "Italy");
		creator.addReference("http://dbpedia.org/resource/Japan", "Japan");
		creator.addReference("http://dbpedia.org/resource/Ladder", "ladder");
		creator.addReference("http://dbpedia.org/resource/Landmark", "landmark");
		creator.addReference("http://dbpedia.org/resource/Lawsuit", "lawsuits");
		creator.addReference("http://dbpedia.org/resource/Leaf", "LEAF");
		creator.addReference("http://dbpedia.org/resource/Leaf_shape", "leaf-shaped");
		creator.addReference("http://dbpedia.org/resource/Lil_Wayne", "Lil Wayne");
		creator.addReference("http://dbpedia.org/resource/Lombard_Street_(San_Francisco)", "Lombard Street");
		creator.addReference("http://dbpedia.org/resource/Los_Angeles", "Los Angeles");
		creator.addReference("http://dbpedia.org/resource/Machine", "machine");
		creator.addReference("http://dbpedia.org/resource/Man", "man");
		creator.addReference("http://dbpedia.org/resource/Man", "men");
		creator.addReference("http://dbpedia.org/resource/Marketing", "marketers");
		creator.addReference("http://dbpedia.org/resource/Medical_cannabis", "marijuana");
		creator.addReference("http://dbpedia.org/resource/Medical_cannabis", "medical marijuana");
		creator.addReference("http://dbpedia.org/resource/Middle_age", "middle-age");
		creator.addReference("http://dbpedia.org/resource/Mikhail_Prokhorov", "Mikhail D. Prokhorov");
		creator.addReference("http://dbpedia.org/resource/Mikhail_Prokhorov", "Prokhorov");
		creator.addReference("http://dbpedia.org/resource/Mile", "miles");
		creator.addReference("http://dbpedia.org/resource/Modernism", "modernist");
		creator.addReference("http://dbpedia.org/resource/Month", "month");
		creator.addReference("http://dbpedia.org/resource/Month", "months");
		creator.addReference("http://dbpedia.org/resource/Moscow", "Moscow");
		creator.addReference("http://dbpedia.org/resource/Mother", "mother");
		creator.addReference("http://dbpedia.org/resource/Multimedia", "multimedia");
		creator.addReference("http://dbpedia.org/resource/Name", "names");
		creator.addReference("http://dbpedia.org/resource/Nausea", "nausea");
		creator.addReference("http://dbpedia.org/resource/Navigation_system", "navigation system");
		creator.addReference("http://dbpedia.org/resource/New_Jersey_Nets", "Nets");
		creator.addReference("http://dbpedia.org/resource/New_York_City", "New York");
		creator.addReference("http://dbpedia.org/resource/Nightclub", "nightclubs");
		creator.addReference("http://dbpedia.org/resource/Nightmare", "nightmare");
		creator.addReference("http://dbpedia.org/resource/Online_and_offline", "offline");
		creator.addReference("http://dbpedia.org/resource/Online_and_offline", "online");
		creator.addReference("http://dbpedia.org/resource/Orthostatic_hypotension", "dizzy spells");
		creator.addReference("http://dbpedia.org/resource/Ownership", "owner");
		creator.addReference("http://dbpedia.org/resource/Parent", "parents");
		creator.addReference("http://dbpedia.org/resource/Park", "park");
		creator.addReference("http://dbpedia.org/resource/People's_Republic_of_China", "China");
		creator.addReference("http://dbpedia.org/resource/Percentage", "percentage");
		creator.addReference("http://dbpedia.org/resource/Performance", "performance");
		creator.addReference("http://dbpedia.org/resource/Person", "person");
		creator.addReference("http://dbpedia.org/resource/Popularity", "popularity");
		creator.addReference("http://dbpedia.org/resource/Port_of_Turku", "Turku’s harbor");
		creator.addReference("http://dbpedia.org/resource/Practice_(learning_method)", "practice");
		creator.addReference("http://dbpedia.org/resource/Presentation", "presentation");
		creator.addReference("http://dbpedia.org/resource/Presidency_of_Barack_Obama", "Obama administration");
		creator.addReference("http://dbpedia.org/resource/Prison", "jail");
		creator.addReference("http://dbpedia.org/resource/Prison", "jailed");
		creator.addReference("http://dbpedia.org/resource/Problem", "problem");
		creator.addReference("http://dbpedia.org/resource/Project", "project");
		creator.addReference("http://dbpedia.org/resource/Promise", "promises");
		creator.addReference("http://dbpedia.org/resource/Pumping_station", "pumping station");
		creator.addReference("http://dbpedia.org/resource/Questionnaire", "questionnaires");
		creator.addReference("http://dbpedia.org/resource/Rear-end_collision", "rear-ended");
		creator.addReference("http://dbpedia.org/resource/Rebirth_(Lil_Wayne_album)", "Rebirth");
		creator.addReference("http://dbpedia.org/resource/Red", "red");
		creator.addReference("http://dbpedia.org/resource/Renminbi", "renminbi");
		creator.addReference("http://dbpedia.org/resource/Research", "research");
		creator.addReference("http://dbpedia.org/resource/Restaurant", "restaurant");
		creator.addReference("http://dbpedia.org/resource/Rikers_Island", "Rikers Island");
		creator.addReference("http://dbpedia.org/resource/Ritual", "rites");
		creator.addReference("http://dbpedia.org/resource/Roof", "roof");
		creator.addReference("http://dbpedia.org/resource/Room", "room");
		creator.addReference("http://dbpedia.org/resource/Runway_(fashion)", "catwalk");
		creator.addReference("http://dbpedia.org/resource/Russia", "Russia");
		creator.addReference("http://dbpedia.org/resource/Russians", "Russians");
		creator.addReference("http://dbpedia.org/resource/San_Francisco", "San Francisco");
		creator.addReference("http://dbpedia.org/resource/Sasha_Waltz", "Sasha Waltz");
		creator.addReference("http://dbpedia.org/resource/Sauna", "sauna");
		creator.addReference("http://dbpedia.org/resource/Scallop", "scallops");
		creator.addReference("http://dbpedia.org/resource/Scar", "scars");
		creator.addReference("http://dbpedia.org/resource/Scientific_method", "scientific");
		creator.addReference("http://dbpedia.org/resource/Sculpture", "sculptor");
		creator.addReference("http://dbpedia.org/resource/Self-consciousness", "self-consciousness");
		creator.addReference("http://dbpedia.org/resource/Self-esteem", "self-esteem");
		creator.addReference("http://dbpedia.org/resource/Sentence_(law)", "sentence");
		creator.addReference("http://dbpedia.org/resource/September", "September");
		creator.addReference("http://dbpedia.org/resource/Shape", "shape");
		creator.addReference("http://dbpedia.org/resource/Shape", "shaped");
		creator.addReference("http://dbpedia.org/resource/Smartphone", "smartphone");
		creator.addReference("http://dbpedia.org/resource/Social_order", "social order");
		creator.addReference("http://dbpedia.org/resource/Social_psychology", "social psychologist");
		creator.addReference("http://dbpedia.org/resource/Social_support", "social support");
		creator.addReference("http://dbpedia.org/resource/Solomon_R._Guggenheim_Museum", "Guggenheim Museum");
		creator.addReference("http://dbpedia.org/resource/Song", "songs");
		creator.addReference("http://dbpedia.org/resource/Source_code", "code");
		creator.addReference("http://dbpedia.org/resource/Sponsor_(commercial)", "sponsors");
		creator.addReference("http://dbpedia.org/resource/Sport", "sport");
		creator.addReference("http://dbpedia.org/resource/Sports_club", "club");
		creator.addReference("http://dbpedia.org/resource/Sportsperson", "players");
		creator.addReference("http://dbpedia.org/resource/Spree", "Spree");
		creator.addReference("http://dbpedia.org/resource/Steering_wheel", "wheel");
		creator.addReference("http://dbpedia.org/resource/Street", "streets");
		creator.addReference("http://dbpedia.org/resource/Studio_recording", "recording");
		creator.addReference("http://dbpedia.org/resource/Sunday", "Sunday");
		creator.addReference("http://dbpedia.org/resource/Team", "team");
		creator.addReference("http://dbpedia.org/resource/Technician", "technician");
		creator.addReference("http://dbpedia.org/resource/Term_(time)", "long-term");
		creator.addReference("http://dbpedia.org/resource/Term_(time)", "short-term");
		creator.addReference("http://dbpedia.org/resource/Ticket_(admission)", "ticket");
		creator.addReference("http://dbpedia.org/resource/Timothy_Geithner", "Timothy F. Geithner");
		creator.addReference("http://dbpedia.org/resource/Toyota_Prius", "Toyota Prius");
		creator.addReference("http://dbpedia.org/resource/Tradition", "traditional");
		creator.addReference("http://dbpedia.org/resource/Traffic_light", "traffic light");
		creator.addReference("http://dbpedia.org/resource/Turku", "Turku");
		creator.addReference("http://dbpedia.org/resource/Undergraduate_education", "undergrads");
		creator.addReference("http://dbpedia.org/resource/Undergraduate_education", "undergraduates");
		creator.addReference("http://dbpedia.org/resource/United_States_Secretary_of_the_Treasury", "Treasury Secretary");
		creator.addReference("http://dbpedia.org/resource/Unter_den_Linden", "Unter den Linden");
		creator.addReference("http://dbpedia.org/resource/Uploading_and_downloading", "downloading");
		creator.addReference("http://dbpedia.org/resource/User_(computing)", "computer users");
		creator.addReference("http://dbpedia.org/resource/User_(computing)", "users");
		creator.addReference("http://dbpedia.org/resource/Video", "video");
		creator.addReference("http://dbpedia.org/resource/Wall", "walls");
		creator.addReference("http://dbpedia.org/resource/Wealth", "wealthy");
		creator.addReference("http://dbpedia.org/resource/Web_browser", "Internet browsing");
		creator.addReference("http://dbpedia.org/resource/Web_developer", "Web developers");
		creator.addReference("http://dbpedia.org/resource/Web_page", "Web pages");
		creator.addReference("http://dbpedia.org/resource/Window", "windows");
		creator.addReference("http://dbpedia.org/resource/Woman", "women");
		creator.addReference("http://dbpedia.org/resource/Woodland", "woods");
		creator.addReference("http://dbpedia.org/resource/World", "world");
		creator.addReference("http://dbpedia.org/resource/World_War_I", "World War I");
		creator.addReference("http://dbpedia.org/resource/World_Wide_Web", "Web");
		creator.addReference("http://dbpedia.org/resource/Worry", "Worries");
		creator.addReference("http://dbpedia.org/resource/Writer", "writer");
		creator.addReference("http://dbpedia.org/resource/Year", "years");
		creator.addReference("http://dbpedia.org/resource/Yellow", "yellow");

		creator.addReference("http://dbpedia.org/resource/2006", "2006");
		creator.addReference("http://dbpedia.org/resource/2011", "2011");
		creator.addReference("http://dbpedia.org/resource/Accident", "Accident");
		creator.addReference("http://dbpedia.org/resource/Accordion", "Accordion");
		creator.addReference("http://dbpedia.org/resource/Advertising", "Advertising");
		creator.addReference("http://dbpedia.org/resource/Aggression", "Aggression");
		creator.addReference("http://dbpedia.org/resource/Alarmism", "Alarmism");
		creator.addReference("http://dbpedia.org/resource/Album", "Album");
		creator.addReference("http://dbpedia.org/resource/Alice_Roosevelt_Longworth", "Alice_Roosevelt_Longworth");
		creator.addReference("http://dbpedia.org/resource/Alzheimer's_disease", "Alzheimer's_disease");
		creator.addReference("http://dbpedia.org/resource/Ancient_Greece", "Ancient_Greece");
		creator.addReference("http://dbpedia.org/resource/Annual_Meetings_of_the_International_Monetary_Fund_and_the_World_Bank_Group", "Annual_Meetings_of_the_International_Monetary_Fund_and_the_World_Bank_Group");
		creator.addReference("http://dbpedia.org/resource/Anxiety", "Anxiety");
		creator.addReference("http://dbpedia.org/resource/Art", "Art");
		creator.addReference("http://dbpedia.org/resource/Art_exhibition", "Art_exhibition");
		creator.addReference("http://dbpedia.org/resource/Artificial_intelligence", "Artificial_intelligence");
		creator.addReference("http://dbpedia.org/resource/Artist", "Artist");
		creator.addReference("http://dbpedia.org/resource/Association_football", "Association_football");
		creator.addReference("http://dbpedia.org/resource/Audience", "Audience");
		creator.addReference("http://dbpedia.org/resource/Automobile", "Automobile");
		creator.addReference("http://dbpedia.org/resource/Autumn", "Autumn");
		creator.addReference("http://dbpedia.org/resource/Backpack", "Backpack");
		creator.addReference("http://dbpedia.org/resource/Balance_of_trade", "Balance_of_trade");
		creator.addReference("http://dbpedia.org/resource/Ballet_tutu", "Ballet_tutu");
		creator.addReference("http://dbpedia.org/resource/Basketball", "Basketball");
		creator.addReference("http://dbpedia.org/resource/Basketball_court", "Basketball_court");
		creator.addReference("http://dbpedia.org/resource/Beef_tenderloin", "Beef_tenderloin");
		creator.addReference("http://dbpedia.org/resource/Berlin", "Berlin");
		creator.addReference("http://dbpedia.org/resource/Berlin_Ostbahnhof", "Berlin_Ostbahnhof");
		creator.addReference("http://dbpedia.org/resource/Billionaire", "Billionaire");
		creator.addReference("http://dbpedia.org/resource/Blue", "Blue");
		creator.addReference("http://dbpedia.org/resource/Boiler", "Boiler");
		creator.addReference("http://dbpedia.org/resource/Boredom", "Boredom");
		creator.addReference("http://dbpedia.org/resource/Boulevard", "Boulevard");
		creator.addReference("http://dbpedia.org/resource/Box_office", "Box_office");
		creator.addReference("http://dbpedia.org/resource/Brick", "Brick");
		creator.addReference("http://dbpedia.org/resource/Buster_Keaton", "Buster_Keaton");
		creator.addReference("http://dbpedia.org/resource/CSKA_Universal_Sports_Hall", "CSKA_Universal_Sports_Hall");
		creator.addReference("http://dbpedia.org/resource/California_State_Route_1", "California_State_Route_1");
		creator.addReference("http://dbpedia.org/resource/Canada", "Canada");
		creator.addReference("http://dbpedia.org/resource/Canadian", "Canadian");
		creator.addReference("http://dbpedia.org/resource/Cancer", "Cancer");
		creator.addReference("http://dbpedia.org/resource/Cannabis_(drug)", "Cannabis_(drug)");
		creator.addReference("http://dbpedia.org/resource/Cappuccino", "Cappuccino");
		creator.addReference("http://dbpedia.org/resource/Chair", "Chair");
		creator.addReference("http://dbpedia.org/resource/Chaos", "Chaos");
		creator.addReference("http://dbpedia.org/resource/Choreography", "Choreography");
		creator.addReference("http://dbpedia.org/resource/Classicism", "Classicism");
		creator.addReference("http://dbpedia.org/resource/Coach_(sport)", "Coach_(sport)");
		creator.addReference("http://dbpedia.org/resource/Commuting", "Commuting");
		creator.addReference("http://dbpedia.org/resource/Computer_software", "Computer_software");
		creator.addReference("http://dbpedia.org/resource/Conservatism", "Conservatism");
		creator.addReference("http://dbpedia.org/resource/Conspiracy_theory", "Conspiracy_theory");
		creator.addReference("http://dbpedia.org/resource/Consumer", "Consumer");
		creator.addReference("http://dbpedia.org/resource/Content_(media)", "Content_(media)");
		creator.addReference("http://dbpedia.org/resource/Country", "Country");
		creator.addReference("http://dbpedia.org/resource/Criminal_charge", "Criminal_charge");
		creator.addReference("http://dbpedia.org/resource/Cubism", "Cubism");
		creator.addReference("http://dbpedia.org/resource/Culture", "Culture");
		creator.addReference("http://dbpedia.org/resource/Currency", "Currency");
		creator.addReference("http://dbpedia.org/resource/Curve", "Curve");
		creator.addReference("http://dbpedia.org/resource/Dance", "Dance");
		creator.addReference("http://dbpedia.org/resource/Dance_troupe", "Dance_troupe");
		creator.addReference("http://dbpedia.org/resource/Dinner", "Dinner");
		creator.addReference("http://dbpedia.org/resource/Diplomatic_mission", "Diplomatic_mission");
		creator.addReference("http://dbpedia.org/resource/Driverless_car", "Driverless_car");
		creator.addReference("http://dbpedia.org/resource/Driving", "Driving");
		creator.addReference("http://dbpedia.org/resource/Drop_(liquid)", "Drop_(liquid)");
		creator.addReference("http://dbpedia.org/resource/Economy", "Economy");
		creator.addReference("http://dbpedia.org/resource/Email", "Email");
		creator.addReference("http://dbpedia.org/resource/Emotion", "Emotion");
		creator.addReference("http://dbpedia.org/resource/Engineer", "Engineer");
		creator.addReference("http://dbpedia.org/resource/Era", "Era");
		creator.addReference("http://dbpedia.org/resource/Europe", "Europe");
		creator.addReference("http://dbpedia.org/resource/Exhibition", "Exhibition");
		creator.addReference("http://dbpedia.org/resource/Exhibition_game", "Exhibition_game");
		creator.addReference("http://dbpedia.org/resource/Experiment", "Experiment");
		creator.addReference("http://dbpedia.org/resource/Family", "Family");
		creator.addReference("http://dbpedia.org/resource/Fan_(person)", "Fan_(person)");
		creator.addReference("http://dbpedia.org/resource/Father", "Father");
		creator.addReference("http://dbpedia.org/resource/Female", "Female");
		creator.addReference("http://dbpedia.org/resource/Festival", "Festival");
		creator.addReference("http://dbpedia.org/resource/Fiberglass", "Fiberglass");
		creator.addReference("http://dbpedia.org/resource/Fiction", "Fiction");
		creator.addReference("http://dbpedia.org/resource/Finland", "Finland");
		creator.addReference("http://dbpedia.org/resource/Finnish_sauna", "Finnish_sauna");
		creator.addReference("http://dbpedia.org/resource/Floor", "Floor");
		creator.addReference("http://dbpedia.org/resource/Floor_plan", "Floor_plan");
		creator.addReference("http://dbpedia.org/resource/France", "France");
		creator.addReference("http://dbpedia.org/resource/Free_association_(psychology)", "Free_association_(psychology)");
		creator.addReference("http://dbpedia.org/resource/Friday", "Friday");
		creator.addReference("http://dbpedia.org/resource/Future", "Future");
		creator.addReference("http://dbpedia.org/resource/Futurism", "Futurism");
		creator.addReference("http://dbpedia.org/resource/Game", "Game");
		creator.addReference("http://dbpedia.org/resource/Garlic", "Garlic");
		creator.addReference("http://dbpedia.org/resource/Germany", "Germany");
		creator.addReference("http://dbpedia.org/resource/Google", "Google");
		creator.addReference("http://dbpedia.org/resource/Google_driverless_car", "Google_driverless_car");
		creator.addReference("http://dbpedia.org/resource/Gossip", "Gossip");
		creator.addReference("http://dbpedia.org/resource/Gothic_architecture", "Gothic_architecture");
		creator.addReference("http://dbpedia.org/resource/Grand_Central_Terminal", "Grand_Central_Terminal");
		creator.addReference("http://dbpedia.org/resource/Green", "Green");
		creator.addReference("http://dbpedia.org/resource/Greeting", "Greeting");
		creator.addReference("http://dbpedia.org/resource/Grounding_(punishment)", "Grounding_(punishment)");
		creator.addReference("http://dbpedia.org/resource/Gun_politics", "Gun_politics");
		creator.addReference("http://dbpedia.org/resource/HTML", "HTML");
		creator.addReference("http://dbpedia.org/resource/HTML5", "HTML5");
		creator.addReference("http://dbpedia.org/resource/Hall", "Hall");
		creator.addReference("http://dbpedia.org/resource/Heart_disease", "Heart_disease");
		creator.addReference("http://dbpedia.org/resource/Hedonism", "Hedonism");
		creator.addReference("http://dbpedia.org/resource/History", "History");
		creator.addReference("http://dbpedia.org/resource/Hockey", "Hockey");
		creator.addReference("http://dbpedia.org/resource/Home", "Home");
		creator.addReference("http://dbpedia.org/resource/House", "House");
		creator.addReference("http://dbpedia.org/resource/House_dance", "House_dance");
		creator.addReference("http://dbpedia.org/resource/Human", "Human");
		creator.addReference("http://dbpedia.org/resource/Husband", "Husband");
		creator.addReference("http://dbpedia.org/resource/I_Am_Not_a_Human_Being", "I_Am_Not_a_Human_Being");
		creator.addReference("http://dbpedia.org/resource/Idea", "Idea");
		creator.addReference("http://dbpedia.org/resource/Ideology", "Ideology");
		creator.addReference("http://dbpedia.org/resource/Illegal_drug_trade", "Illegal_drug_trade");
		creator.addReference("http://dbpedia.org/resource/Illinois", "Illinois");
		creator.addReference("http://dbpedia.org/resource/Information_privacy", "Information_privacy");
		creator.addReference("http://dbpedia.org/resource/Interaction", "Interaction");
		creator.addReference("http://dbpedia.org/resource/Interior_design", "Interior_design");
		creator.addReference("http://dbpedia.org/resource/International", "International");
		creator.addReference("http://dbpedia.org/resource/Internet", "Internet");
		creator.addReference("http://dbpedia.org/resource/Internet_privacy", "Internet_privacy");
		creator.addReference("http://dbpedia.org/resource/Italian_Renaissance", "Italian_Renaissance");
		creator.addReference("http://dbpedia.org/resource/Italy", "Italy");
		creator.addReference("http://dbpedia.org/resource/Japan", "Japan");
		creator.addReference("http://dbpedia.org/resource/Ladder", "Ladder");
		creator.addReference("http://dbpedia.org/resource/Landmark", "Landmark");
		creator.addReference("http://dbpedia.org/resource/Lawsuit", "Lawsuit");
		creator.addReference("http://dbpedia.org/resource/Leaf", "Leaf");
		creator.addReference("http://dbpedia.org/resource/Leaf_shape", "Leaf_shape");
		creator.addReference("http://dbpedia.org/resource/Lil_Wayne", "Lil_Wayne");
		creator.addReference("http://dbpedia.org/resource/Lombard_Street_(San_Francisco)", "Lombard_Street_(San_Francisco)");
		creator.addReference("http://dbpedia.org/resource/Los_Angeles", "Los_Angeles");
		creator.addReference("http://dbpedia.org/resource/Machine", "Machine");
		creator.addReference("http://dbpedia.org/resource/Man", "Man");
		creator.addReference("http://dbpedia.org/resource/Marketing", "Marketing");
		creator.addReference("http://dbpedia.org/resource/Markup_language", "Markup_language");
		creator.addReference("http://dbpedia.org/resource/Medical_cannabis", "Medical_cannabis");
		creator.addReference("http://dbpedia.org/resource/Middle_age", "Middle_age");
		creator.addReference("http://dbpedia.org/resource/Mikhail_Prokhorov", "Mikhail_Prokhorov");
		creator.addReference("http://dbpedia.org/resource/Mile", "Mile");
		creator.addReference("http://dbpedia.org/resource/Modernism", "Modernism");
		creator.addReference("http://dbpedia.org/resource/Month", "Month");
		creator.addReference("http://dbpedia.org/resource/Moscow", "Moscow");
		creator.addReference("http://dbpedia.org/resource/Mother", "Mother");
		creator.addReference("http://dbpedia.org/resource/Multimedia", "Multimedia");
		creator.addReference("http://dbpedia.org/resource/Name", "Name");
		creator.addReference("http://dbpedia.org/resource/Nausea", "Nausea");
		creator.addReference("http://dbpedia.org/resource/Navigation_system", "Navigation_system");
		creator.addReference("http://dbpedia.org/resource/New_Jersey_Nets", "New_Jersey_Nets");
		creator.addReference("http://dbpedia.org/resource/New_York_City", "New_York_City");
		creator.addReference("http://dbpedia.org/resource/Nightclub", "Nightclub");
		creator.addReference("http://dbpedia.org/resource/Nightmare", "Nightmare");
		creator.addReference("http://dbpedia.org/resource/Online_and_offline", "Online_and_offline");
		creator.addReference("http://dbpedia.org/resource/Orthostatic_hypotension", "Orthostatic_hypotension");
		creator.addReference("http://dbpedia.org/resource/Ownership", "Ownership");
		creator.addReference("http://dbpedia.org/resource/PBC_CSKA_Moscow", "PBC_CSKA_Moscow");
		creator.addReference("http://dbpedia.org/resource/Parent", "Parent");
		creator.addReference("http://dbpedia.org/resource/Park", "Park");
		creator.addReference("http://dbpedia.org/resource/People's_Republic_of_China", "People's_Republic_of_China");
		creator.addReference("http://dbpedia.org/resource/Percentage", "Percentage");
		creator.addReference("http://dbpedia.org/resource/Performance", "Performance");
		creator.addReference("http://dbpedia.org/resource/Person", "Person");
		creator.addReference("http://dbpedia.org/resource/Popularity", "Popularity");
		creator.addReference("http://dbpedia.org/resource/Port_of_Turku", "Port_of_Turku");
		creator.addReference("http://dbpedia.org/resource/Practice_(learning_method)", "Practice_(learning_method)");
		creator.addReference("http://dbpedia.org/resource/Presentation", "Presentation");
		creator.addReference("http://dbpedia.org/resource/Presidency_of_Barack_Obama", "Presidency_of_Barack_Obama");
		creator.addReference("http://dbpedia.org/resource/Prison", "Prison");
		creator.addReference("http://dbpedia.org/resource/Problem", "Problem");
		creator.addReference("http://dbpedia.org/resource/Project", "Project");
		creator.addReference("http://dbpedia.org/resource/Promise", "Promise");
		creator.addReference("http://dbpedia.org/resource/Pumping_station", "Pumping_station");
		creator.addReference("http://dbpedia.org/resource/Questionnaire", "Questionnaire");
		creator.addReference("http://dbpedia.org/resource/Rear-end_collision", "Rear-end_collision");
		creator.addReference("http://dbpedia.org/resource/Rebirth_(Lil_Wayne_album)", "Rebirth_(Lil_Wayne_album)");
		creator.addReference("http://dbpedia.org/resource/Red", "Red");
		creator.addReference("http://dbpedia.org/resource/Renminbi", "Renminbi");
		creator.addReference("http://dbpedia.org/resource/Research", "Research");
		creator.addReference("http://dbpedia.org/resource/Restaurant", "Restaurant");
		creator.addReference("http://dbpedia.org/resource/Rikers_Island", "Rikers_Island");
		creator.addReference("http://dbpedia.org/resource/Ritual", "Ritual");
		creator.addReference("http://dbpedia.org/resource/Roof", "Roof");
		creator.addReference("http://dbpedia.org/resource/Room", "Room");
		creator.addReference("http://dbpedia.org/resource/Runway_(fashion)", "Runway_(fashion)");
		creator.addReference("http://dbpedia.org/resource/Russia", "Russia");
		creator.addReference("http://dbpedia.org/resource/Russians", "Russians");
		creator.addReference("http://dbpedia.org/resource/San_Francisco", "San_Francisco");
		creator.addReference("http://dbpedia.org/resource/Sasha_Waltz", "Sasha_Waltz");
		creator.addReference("http://dbpedia.org/resource/Sauna", "Sauna");
		creator.addReference("http://dbpedia.org/resource/Scallop", "Scallop");
		creator.addReference("http://dbpedia.org/resource/Scar", "Scar");
		creator.addReference("http://dbpedia.org/resource/Scientific_method", "Scientific_method");
		creator.addReference("http://dbpedia.org/resource/Sculpture", "Sculpture");
		creator.addReference("http://dbpedia.org/resource/Self-consciousness", "Self-consciousness");
		creator.addReference("http://dbpedia.org/resource/Self-esteem", "Self-esteem");
		creator.addReference("http://dbpedia.org/resource/Sentence_(law)", "Sentence_(law)");
		creator.addReference("http://dbpedia.org/resource/September", "September");
		creator.addReference("http://dbpedia.org/resource/Shape", "Shape");
		creator.addReference("http://dbpedia.org/resource/Smartphone", "Smartphone");
		creator.addReference("http://dbpedia.org/resource/Social_order", "Social_order");
		creator.addReference("http://dbpedia.org/resource/Social_psychology", "Social_psychology");
		creator.addReference("http://dbpedia.org/resource/Social_support", "Social_support");
		creator.addReference("http://dbpedia.org/resource/Solomon_R._Guggenheim_Museum", "Solomon_R._Guggenheim_Museum");
		creator.addReference("http://dbpedia.org/resource/Song", "Song");
		creator.addReference("http://dbpedia.org/resource/Source_code", "Source_code");
		creator.addReference("http://dbpedia.org/resource/Sponsor_(commercial)", "Sponsor_(commercial)");
		creator.addReference("http://dbpedia.org/resource/Sport", "Sport");
		creator.addReference("http://dbpedia.org/resource/Sports_club", "Sports_club");
		creator.addReference("http://dbpedia.org/resource/Sportsperson", "Sportsperson");
		creator.addReference("http://dbpedia.org/resource/Spree", "Spree");
		creator.addReference("http://dbpedia.org/resource/Steering_wheel", "Steering_wheel");
		creator.addReference("http://dbpedia.org/resource/Street", "Street");
		creator.addReference("http://dbpedia.org/resource/Studio_recording", "Studio_recording");
		creator.addReference("http://dbpedia.org/resource/Sunday", "Sunday");
		creator.addReference("http://dbpedia.org/resource/Team", "Team");
		creator.addReference("http://dbpedia.org/resource/Technician", "Technician");
		creator.addReference("http://dbpedia.org/resource/Term_(time)", "Term_(time)");
		creator.addReference("http://dbpedia.org/resource/Ticket_(admission)", "Ticket_(admission)");
		creator.addReference("http://dbpedia.org/resource/Timothy_Geithner", "Timothy_Geithner");
		creator.addReference("http://dbpedia.org/resource/Toyota_Prius", "Toyota_Prius");
		creator.addReference("http://dbpedia.org/resource/Tradition", "Tradition");
		creator.addReference("http://dbpedia.org/resource/Traffic_light", "Traffic_light");
		creator.addReference("http://dbpedia.org/resource/Turku", "Turku");
		creator.addReference("http://dbpedia.org/resource/Undergraduate_education", "Undergraduate_education");
		creator.addReference("http://dbpedia.org/resource/United_States_Secretary_of_the_Treasury", "United_States_Secretary_of_the_Treasury");
		creator.addReference("http://dbpedia.org/resource/Unter_den_Linden", "Unter_den_Linden");
		creator.addReference("http://dbpedia.org/resource/Uploading_and_downloading", "Uploading_and_downloading");
		creator.addReference("http://dbpedia.org/resource/User_(computing)", "User_(computing)");
		creator.addReference("http://dbpedia.org/resource/Video", "Video");
		creator.addReference("http://dbpedia.org/resource/Wall", "Wall");
		creator.addReference("http://dbpedia.org/resource/Wealth", "Wealth");
		creator.addReference("http://dbpedia.org/resource/Web_browser", "Web_browser");
		creator.addReference("http://dbpedia.org/resource/Web_developer", "Web_developer");
		creator.addReference("http://dbpedia.org/resource/Web_page", "Web_page");
		creator.addReference("http://dbpedia.org/resource/Window", "Window");
		creator.addReference("http://dbpedia.org/resource/Woman", "Woman");
		creator.addReference("http://dbpedia.org/resource/Woodland", "Woodland");
		creator.addReference("http://dbpedia.org/resource/World", "World");
		creator.addReference("http://dbpedia.org/resource/World_War_I", "World_War_I");
		creator.addReference("http://dbpedia.org/resource/World_Wide_Web", "World_Wide_Web");
		creator.addReference("http://dbpedia.org/resource/Worry", "Worry");
		creator.addReference("http://dbpedia.org/resource/Writer", "Writer");
		creator.addReference("http://dbpedia.org/resource/Year", "Year");
		creator.addReference("http://dbpedia.org/resource/Yellow", "Yellow");

		try {
			PrintWriter out = new PrintWriter("/tmp/dbpedia-spotlight-nif.ttl", "UTF-8");
			out.println(creator.toString());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

	public NIFcreator() {

		mainContexts = new HashMap<String, Context>();
		references = new HashMap<String, String>();

	}

	public void addText(String sourceUri, String text) {
		Context c = new Context(sourceUri, text, 0, text.length() - 1);
		mainContexts.put(sourceUri, c);
	}

	private void addSentence(String sourceUri, String text) {
		Context c = mainContexts.get(sourceUri);

		if (c == null) {
			L.warning("No context for " + sourceUri);
			return;
		}

		int begin = c.text.indexOf(text);
		int end = begin + text.length() - 1;
		Context narrower = new Context(sourceUri, text, begin, end);

		c.addNarrower(narrower);
	}

	public void addReference(String uri, String surfaceform) {
		surfaceform = surfaceform.replaceAll("_", " ");
		for (Context c : mainContexts.values()) {
			int startPos = 0;
			while (startPos < c.end) {
				if (StringUtils.containsIgnoreCase(c.text.substring(startPos), surfaceform)) {
					Boolean skip = false;
					
					int begin = StringUtils.indexOfIgnoreCase(c.text, surfaceform, startPos);
					int end = begin + surfaceform.length();
	
					L.info("Found mention of \"" + surfaceform + "\" at [" + begin + "," + end + "].");
	
					Context rc = c.getNarrower(begin, end);
					String text = c.text.substring(begin, end);
					Phrase p = new Phrase(c.sourceUri, text, begin, end, uri, rc);
					
					if (begin != 0 && c.text.charAt(begin - 1) != ' ') {
						L.info("\"" + p.text + "\" needs validation: char before.");
						p.needsValidation += "\"" + p.text + "\" needs validation: char before: '" + c.text.charAt(begin - 1) + "' -- ";
					}
					if (c.text.charAt(end) != ' ' && c.text.charAt(end) != '.'  && c.text.charAt(end) != ',') {
						L.info("\"" + p.text + "\" needs validation: char after.");
						p.needsValidation += "\"" + p.text + "\" needs validation: char after: '" + c.text.charAt(end) + "' -- ";
					}
	
					for (Phrase pt : rc.references) {
						if (pt.begin == p.begin && pt.end == p.end) {
							L.info("Mention already exists at [" + pt.begin + "," + pt.end + "].");
							skip = true;
							continue;
						}
						if ((pt.begin <= p.begin && pt.end > p.begin) || (pt.begin > p.begin && pt.begin <= p.end)) {
							L.info("\"" + p.text + "\" needs validation: overlap with \"" + pt.text + "\".");
							p.needsValidation += "\"" + p.text + "\" needs validation: overlap with \"" + pt.text + "\" [" + pt.begin + "," + pt.end + "] -- ";
						}
					}
					
					if (!skip) {
						rc.addPhrase(p);
					}
					
					startPos = end;
				} else {
					startPos = c.end;
				}
			}
		}

		references.put(surfaceform, uri);
	}

	@Override
	public String toString() {
		String r = new String();

		for (Context c : mainContexts.values()) {
			r = r + "\n\n---\n\n" + c.toString();
		}

		return r;
	}

}
