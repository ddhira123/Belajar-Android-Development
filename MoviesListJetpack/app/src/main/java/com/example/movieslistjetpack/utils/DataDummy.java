package com.example.movieslistjetpack.utils;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.remote.response.MovieResponse;
import com.example.movieslistjetpack.data.source.remote.response.TVShowResponse;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {
    public static List<MovieEntity> generateDummyMovies() {
        ArrayList<MovieEntity> movies = new ArrayList<>();

        movies.add(new MovieEntity("0",
                "X-Men",
                "In a world where mutants (evolved super-powered humans) exist and are discriminated against, two groups form for an inevitable clash: the supremacist Brotherhood, and the pacifist X-Men.",
                "2000",
                "Patrick Stewart, Hugh Jackman, Ian McKellen",
                "Action, Adventure, Sci-Fi",
                "7.4",
                "https://m.media-amazon.com/images/M/MV5BZmIyMDk5NGYtYjQ5NS00ZWQxLTg2YzQtZDk1ZmM4ZDBlN2E3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"));

        movies.add(new MovieEntity("1",
                "X-Men 2",
                "Several months have passed since the X-Men defeated Magneto and imprisoned him in a seemingly impregnable plastic chamber. One day, a mutant by the name of Nightcrawler infiltrates the White House and attempts to assassinate the President, setting off a chain reaction of anti-mutant measures by the government. Meanwhile, Logan is trying to discover his past. As scientist named William Stryker discovers Professor X's secret school and Cerebro, Magneto's partner, Mystique, is planning to break her leader out of prison. But when Professor X's school is attacked by Stryker's forces, Logan, Rogue, Iceman, and a few are lucky to escape. Those who remain meet in Boston, where they form an uneasy alliance with Magneto to stop Stryker and rescue Professor X",
                "2003",
                "Patrick Stewart, Hugh Jackman, Halle Berry",
                "Action, Adventure, Sci-Fi",
                "7.4",
                "https://m.media-amazon.com/images/M/MV5BNDk0NjYxMzIzOF5BMl5BanBnXkFtZTYwMTc1MjU3._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("2",
                "X-Men: The Last Stand",
                "When a \"cure\" is created, which apparently can turn any mutant into a \"normal\" human being, there is outrage amongst the mutant community. While some mutants do like the idea of a \"cure\", including Rogue, many mutants find that there shouldn't be a \"cure\". Magneto, who still believes a war is coming, recruits a large team of mutants to take down Warren Worthington II and his \"cure\". Might seem easy for the X-Men to stop, but Magneto has a big advantage, which Wolverine doesn't have. Jean Grey has returned, and joined with Magneto. The Dark Phoenix has woken within her, which has the ability to destroy anything in her way, even if that \"anything\" is an X-Man.",
                "2006",
                "Patrick Stewart, Hugh Jackman, Halle Berry",
                "Action, Adventure, Sci-Fi",
                "6.7",
                "https://m.media-amazon.com/images/M/MV5BNDBhNDJiMWEtOTg4Yi00NTYzLWEzOGMtMjNmNjAxNTBlMzY3XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UY268_CR1,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("3",
                "X-Men Origins: Wolverine",
                "Two mutant brothers, Logan and Victor, born two hundred years ago, suffer childhood trauma and have only each other to depend on. Basically, they're fighters and killers, living from war to war throughout U.S. history. In modern times, a U.S. Colonel, Stryker, recruits them and other mutants as commandos. Logan quits and becomes a logger, falling in love with a local teacher. When Logan refuses to rejoin Stryker's crew, the Colonel sends the murderous Victor. Logan now wants revenge.",
                "2009",
                "Hugh Jackman, Liev Schreiber, Ryan Reynolds",
                "Action, Adventure, Sci-Fi",
                "6.6",
                "https://m.media-amazon.com/images/M/MV5BZWRhMzdhMzEtZTViNy00YWYyLTgxZmUtMTMwMWM0NTEyMjk3XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("4",
                "X-Men: First Class",
                "Before Charles Xavier and Erik Lensherr took the names Professor X and Magneto, they were two young men discovering their powers for the first time. Before they were archenemies, they were closest of friends, working together, with other Mutants (some familiar, some new), to stop the greatest threat the world has ever known. In the process, a rift between them opened, which began the eternal war between Magneto's Brotherhood and Professor X's X-MEN.",
                "2011",
                "James McAvoy, Michael Fassbender, Jennifer Lawrence",
                "Action, Adventure, Sci-Fi",
                "7.7",
                "https://m.media-amazon.com/images/M/MV5BMTg5OTMxNzk4Nl5BMl5BanBnXkFtZTcwOTk1MjAwNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("5",
                "The Wolverine",
                "In modern day Japan, Wolverine is out of his depth in an unknown world as he faces his ultimate nemesis in a life-or-death battle that will leave him forever changed. Vulnerable for the first time and pushed to his physical and emotional limits, he confronts not only lethal samurai steel but also his inner struggle against his own near-immortality, emerging more powerful than we have ever seen him before.",
                "2013",
                "Hugh Jackman, Will Yun Lee, Tao Okamoto",
                "Action, Adventure, Sci-Fi",
                "6.7",
                "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("6",
                "X-Men: Days of Future Past",
                "In the future, the mutants and the humans who help them are slaughtered by powerful robots named Sentinels. Professor Xavier, Wolverine, Magneto, Storm, Kitty Pryde, and her friends meet at a monastery in China and Xavier explains that the invincible Sentinels were created using the DNA of Mystique that was captured in 1973 when she tried to assassinate their creator Dr. Bolivar Trask. Xavier tells that their only chance is return to 1973 using Pryde's ability to join Charles Xavier and Erik Lehnsherr to convince Mystique to give up her intention. However, only Wolverine can withstand the damages of the time travel. Will he succeed in stopping Mystique and the Sentinel Program, and save the mutants and their human friends from annihilation?",
                "2014",
                "Patrick Stewart, Ian McKellen, Hugh Jackman",
                "Action, Adventure, Sci-Fi",
                "7.9",
                "https://m.media-amazon.com/images/M/MV5BZGIzNWYzN2YtMjcwYS00YjQ3LWI2NjMtOTNiYTUyYjE2MGNkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("7",
                "X-Men: Apocalypse",
                "Since the dawn of civilization, he was worshiped as a god. Apocalypse, the first and most powerful mutant from Marvel's X-Men universe, amassed the powers of many other mutants, becoming immortal and invincible. Upon awakening after thousands of years, he is disillusioned with the world as he finds it and recruits a team of powerful mutants, including a disheartened Magneto, to cleanse mankind and create a new world order, over which he will reign. As the fate of the Earth hangs in the balance, Raven with the help of Professor X must lead a team of young X-Men to stop their greatest nemesis and save mankind from complete destruction.",
                "2016",
                "James McAvoy, Michael Fassbender, Jennifer Lawrence",
                "Action, Adventure, Sci-Fi",
                "6.9",
                "https://m.media-amazon.com/images/M/MV5BMjU1ODM1MzYxN15BMl5BanBnXkFtZTgwOTA4NDE2ODE@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("8",
                "Logan",
                "In 2029 the mutant population has shrunken significantly due to genetically modified plants designed to reduce mutant powers and the X-Men have disbanded. Logan, whose power to self-heal is dwindling, has surrendered himself to alcohol and now earns a living as a chauffeur. He takes care of the ailing old Professor X whom he keeps hidden away. One day, a female stranger asks Logan to drive a girl named Laura to the Canadian border. At first he refuses, but the Professor has been waiting for a long time for her to appear. Laura possesses an extraordinary fighting prowess and is in many ways like Wolverine. She is pursued by sinister figures working for a powerful corporation; this is because they made her, with Logan's DNA. A decrepit Logan is forced to ask himself if he can or even wants to put his remaining powers to good use. It would appear that in the near-future, the times in which they were able put the world to rights with razor sharp claws and telepathic powers are now over.",
                "2017",
                "Hugh Jackman, Patrick Stewart, Dafne Keen",
                "Action, Drama, Sci-Fi",
                "8.1",
                "https://m.media-amazon.com/images/M/MV5BYzc5MTU4N2EtYTkyMi00NjdhLTg3NWEtMTY4OTEyMzJhZTAzXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieEntity("9",
                "X-Men: Dark Phoenix",
                "The X-Men. Protectors of peace. Jean Grey is one of the most beloved X-Men. But when a mission goes wrong, Jean is exposed to a dark and ancient power. This power has destroyed everything it comes in contact with, until her. Now that this power is becoming unstable, she releases it with destruction and anger. Now that this foreign power is consuming her, and the world is threatened, the X-Men have to face an important truth: they must save either the world, or their friend who threatens it.",
                "2019",
                "James McAvoy, Michael Fassbender, Jennifer Lawrence",
                "Action, Adventure, Sci-Fi",
                "5.8",
                "https://m.media-amazon.com/images/M/MV5BMmZmYTgwZGItNDIxMS00MmRkLWEzODQtYTllNzM0ZWE1NmQ5XkEyXkFqcGdeQXVyODQzNTE3ODc@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        return movies;
    }

    public static List<TVShowEntity> generateDummyTVShows(){
        ArrayList<TVShowEntity> tvShows = new ArrayList<>();

        tvShows.add(new TVShowEntity(
                "0",
                "Band of Brothers",
                "This is the story of \"E\" Easy Company, 506th Regiment of the 101st Airborne Division from their initial training starting in 1942 to the end of World War II. They parachuted behind enemy lines in the early hours of D-Day in support of the landings at Utah beach, participated in the liberation of Carentan and again parachuted into action during Operation Market Garden. They also liberated a concentration camp and were the first to enter Hitler's mountain retreat in Berchtesgaden. A fascinating tale of comradeship that is, in the end, a tale of ordinary men who did extraordinary things.",
                "Action, Drama, History",
                "2001",
                "Scott Grimes, Damian Lewis, Ron Livingston",
                "9.4",
                "https://m.media-amazon.com/images/M/MV5BMTI3ODc2ODc0M15BMl5BanBnXkFtZTYwMjgzNjc3._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "1",
                "The Wire",
                "Set in Baltimore, this show centers around the city's inner-city drug scene. It starts as mid-level drug dealer, D'Angelo Barksdale beats a murder rap. After a conversation with a judge, Det. James McNulty has been assigned to lead a joint homicide and narcotics team, in order to bring down drug kingpin Avon Barksdale. Avon Barksdale, accompanied by his right-hand man Stringer Bell, enforcer Wee-Bey and many lieutenants (including his own nephew, D'Angelo Barksdale), has to deal with law enforcement, informants in his own camp, and competition with a local rival, Omar, who's been robbing Barksdale's dealers and reselling the drugs. The supervisor of the investigation, Lt. Cedric Daniels, has to deal with his own problems, such as a corrupt bureaucracy, some of his detectives beating suspects, hard-headed but determined Det. McNulty, and a blackmailing deputy. The show depicts the lives of every part of the drug \"food chain\", from junkies to dealers, and from cops to politicians.",
                "Crime, Drama, Thriller",
                "2002-2008",
                "Dominic West, Lance Reddick, Sonja Sohn",
                "9.3",
                "https://m.media-amazon.com/images/M/MV5BZmY5ZDMxODEtNWIwOS00NjdkLTkyMjktNWRjMDhmYjJjN2RmXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "2",
                "Avatar: The Last Airbender",
                "The world is divided into four elemental nations: The Northern and Southern Water Tribes, the Earth Kingdom, the Fire Nation, and the Air Nomads. The Avatar upholds the balance between the nations, but everything changed when the Fire Nation invaded. Only the Avatar, master of all four elements, can stop them. But when the world needs him most, he vanishes. A hundred years later Katara and Sokka discover the new Avatar, an airbender named Aang. Together they must help Aang master the elements and save the world.",
                "Animation, Action, Adventure",
                "2005-2008",
                "Zach Tyler, Mae Whitman, Jack De Sena",
                "9.2",
                "https://m.media-amazon.com/images/M/MV5BODc5YTBhMTItMjhkNi00ZTIxLWI0YjAtNTZmOTY0YjRlZGQ0XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "3",
                "Life",
                "David Attenborough's legendary BBC crew explains and shows wildlife all over planet earth in 10 episodes. The first is an overview of the challenges facing life, the others are dedicated to hunting, the deep sea and various major evolutionary groups of creatures: plants, primates and other large sections of other vertebrates and invertebrates.",
                "Documentary",
                "2009",
                "Oprah Winfrey, David Attenborough",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BNjJhMTAxZjYtNWZkYy00Nzg1LTlkYjItZTNhZWRjNzkxMDg3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR3,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "4",
                "Fullmetal Alchemist: Brotherhood",
                "Two brothers lose their mother to an incurable disease. With the power of \"alchemy\", they use taboo knowledge to resurrect her. The process fails, and as a toll for using this type of alchemy, the older brother, Edward Elric loses his left leg while the younger brother, Alphonse Elric loses his entire body. To save his brother, Edward sacrifices his right arm and is able to affix his brother's soul to a suit of armor. With the help of a family friend, Edward receives metal limbs - \"automail\" - to replace his lost ones. With that, Edward vows to search for the Philosopher's Stone to return the brothers to their original bodies, even if it means becoming a \"State Alchemist\", one who uses his/her alchemy for the military.",
                "Animation, Action, Adventure",
                "2009-2012",
                "Kent Williams, Iemasa Kayumi, Vic Mignogna",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BZmEzN2YzOTItMDI5MS00MGU4LWI1NWQtOTg5ZThhNGQwYTEzXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR4,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "5",
                "Sherlock",
                "In this modernized version of the Conan Doyle characters, using his detective plots, Sherlock Holmes lives in early 21st century London and acts more cocky towards Scotland Yard's detective inspector Lestrade because he's actually less confident. Doctor Watson is now a fairly young veteran of the Afghan war, less adoring and more active.",
                "Crime, Drama, Mystery",
                "2010-2017",
                "Benedict Cumberbatch, Martin Freeman, Una Stubbs",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BMWY3NTljMjEtYzRiMi00NWM2LTkzNjItZTVmZjE0MTdjMjJhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTQ4NTc5OTU@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "6",
                "Planet Earth",
                "Each 50 minute episode features a global overview of a different biome or habitat on Earth (Polar, Mountain, Cave, Desert, Plains, Fresh Water, Seas, Ocean, Forest), followed by a ten-minute featurette which takes a behind-the-scenes look at the challenges of filming the episode.",
                "Documentary",
                "2006",
                "David Attenborough, Sigourney Weaver, Thomas Anguti Johnston",
                "9.4",
                "https://m.media-amazon.com/images/M/MV5BNmZlYzIzMTItY2EzYS00YTEyLTg0ZjEtMDMzZjM3ODdhN2UzXkEyXkFqcGdeQXVyNjI0MDg2NzE@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "7",
                "Game of Thrones",
                "In the mythical continent of Westeros, several powerful families fight for control of the Seven Kingdoms. As conflict erupts in the kingdoms of men, an ancient enemy rises once again to threaten them all. Meanwhile, the last heirs of a recently usurped dynasty plot to take back their homeland from across the Narrow Sea.",
                "Action, Adventure, Drama",
                "2011-2019",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                "9.3",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_UY268_CR7,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "8",
                "Persona (Sahsiyet)",
                "Agâh is a retired 65-year-old judicial clerk, who crosses roads with Nevra, the only female police officer in the homicide office. Is it only a coincidence that Agâh and Nevra approach each other? Agâh Beyoglu, a retired judicial officer, is living alone in Beyoglu, Istanbul's most populous and lively district. His daughter lived abroad, his wife died years ago. This monotonous life of Agâh is upset by the diagnosis of Alzheimer's beginning. He will forget all his memories because of his illness. Even if we do not accept this fact at first, Agâh realizes that forgetting is an opportunity. An opportunity to commit a murder he has planned for years. He will not remember this crime in the future and he will not take remorse for not remembering it. Meanwhile, Nevra, the female police officer in the murder desk, was on the verge of resignation because of the pressure on her. However, the murder decision of Agâh will completely change the life of Nevra.",
                "Crime, Drama, Mystery",
                "2018",
                "Haluk Bilginer, Cansu Dere, Metin Akdülger",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BOTJkNzJmYzgtZTZmNC00MTQ2LWE2ZGQtM2EyYjliNGViMTY5XkEyXkFqcGdeQXVyNDg4MjkzNDk@._V1_UY268_CR4,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowEntity(
                "9",
                "Batman: The Animated Series",
                "Heir to the Wayne family fortune, Bruce Wayne (Kevin Conroy) lives by day as a seemingly lavish playboy millionaire socialite, but by night assumes the role of his crime-fighting alter-ego: the caped crusader known as Batman. Throughout the show, Batman receives help from sidekicks Robin (Loren Lester) and Batgirl (Melissa Gilbert), as well as Police Commissioner Gordon (Bob Hastings), in protecting the streets of Gotham City from a large rogue's gallery of criminals, lunatics, and nemeses.",
                "Animation, Action, Adventure",
                "1992-1995",
                "Kevin Conroy, Loren Lester, Efrem Zimbalist Jr.",
                "9.0",
                "https://m.media-amazon.com/images/M/MV5BOTM3MTRkZjQtYjBkMy00YWE1LTkxOTQtNDQyNGY0YjYzNzAzXkEyXkFqcGdeQXVyOTgwMzk1MTA@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));
        return tvShows;
    }

    public static List<MovieResponse> generateRemoteDummyMovies() {
        ArrayList<MovieResponse> movies = new ArrayList<>();

        movies.add(new MovieResponse("0",
                "X-Men",
                "In a world where mutants (evolved super-powered humans) exist and are discriminated against, two groups form for an inevitable clash: the supremacist Brotherhood, and the pacifist X-Men.",
                "2000",
                "Patrick Stewart, Hugh Jackman, Ian McKellen",
                "Action, Adventure, Sci-Fi",
                "7.4",
                "https://m.media-amazon.com/images/M/MV5BZmIyMDk5NGYtYjQ5NS00ZWQxLTg2YzQtZDk1ZmM4ZDBlN2E3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"));

        movies.add(new MovieResponse("1",
                "X-Men 2",
                "Several months have passed since the X-Men defeated Magneto and imprisoned him in a seemingly impregnable plastic chamber. One day, a mutant by the name of Nightcrawler infiltrates the White House and attempts to assassinate the President, setting off a chain reaction of anti-mutant measures by the government. Meanwhile, Logan is trying to discover his past. As scientist named William Stryker discovers Professor X's secret school and Cerebro, Magneto's partner, Mystique, is planning to break her leader out of prison. But when Professor X's school is attacked by Stryker's forces, Logan, Rogue, Iceman, and a few are lucky to escape. Those who remain meet in Boston, where they form an uneasy alliance with Magneto to stop Stryker and rescue Professor X",
                "2003",
                "Patrick Stewart, Hugh Jackman, Halle Berry",
                "Action, Adventure, Sci-Fi",
                "7.4",
                "https://m.media-amazon.com/images/M/MV5BNDk0NjYxMzIzOF5BMl5BanBnXkFtZTYwMTc1MjU3._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("2",
                "X-Men: The Last Stand",
                "When a \"cure\" is created, which apparently can turn any mutant into a \"normal\" human being, there is outrage amongst the mutant community. While some mutants do like the idea of a \"cure\", including Rogue, many mutants find that there shouldn't be a \"cure\". Magneto, who still believes a war is coming, recruits a large team of mutants to take down Warren Worthington II and his \"cure\". Might seem easy for the X-Men to stop, but Magneto has a big advantage, which Wolverine doesn't have. Jean Grey has returned, and joined with Magneto. The Dark Phoenix has woken within her, which has the ability to destroy anything in her way, even if that \"anything\" is an X-Man.",
                "2006",
                "Patrick Stewart, Hugh Jackman, Halle Berry",
                "Action, Adventure, Sci-Fi",
                "6.7",
                "https://m.media-amazon.com/images/M/MV5BNDBhNDJiMWEtOTg4Yi00NTYzLWEzOGMtMjNmNjAxNTBlMzY3XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UY268_CR1,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("3",
                "X-Men Origins: Wolverine",
                "Two mutant brothers, Logan and Victor, born two hundred years ago, suffer childhood trauma and have only each other to depend on. Basically, they're fighters and killers, living from war to war throughout U.S. history. In modern times, a U.S. Colonel, Stryker, recruits them and other mutants as commandos. Logan quits and becomes a logger, falling in love with a local teacher. When Logan refuses to rejoin Stryker's crew, the Colonel sends the murderous Victor. Logan now wants revenge.",
                "2009",
                "Hugh Jackman, Liev Schreiber, Ryan Reynolds",
                "Action, Adventure, Sci-Fi",
                "6.6",
                "https://m.media-amazon.com/images/M/MV5BZWRhMzdhMzEtZTViNy00YWYyLTgxZmUtMTMwMWM0NTEyMjk3XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("4",
                "X-Men: First Class",
                "Before Charles Xavier and Erik Lensherr took the names Professor X and Magneto, they were two young men discovering their powers for the first time. Before they were archenemies, they were closest of friends, working together, with other Mutants (some familiar, some new), to stop the greatest threat the world has ever known. In the process, a rift between them opened, which began the eternal war between Magneto's Brotherhood and Professor X's X-MEN.",
                "2011",
                "James McAvoy, Michael Fassbender, Jennifer Lawrence",
                "Action, Adventure, Sci-Fi",
                "7.7",
                "https://m.media-amazon.com/images/M/MV5BMTg5OTMxNzk4Nl5BMl5BanBnXkFtZTcwOTk1MjAwNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("5",
                "The Wolverine",
                "In modern day Japan, Wolverine is out of his depth in an unknown world as he faces his ultimate nemesis in a life-or-death battle that will leave him forever changed. Vulnerable for the first time and pushed to his physical and emotional limits, he confronts not only lethal samurai steel but also his inner struggle against his own near-immortality, emerging more powerful than we have ever seen him before.",
                "2013",
                "Hugh Jackman, Will Yun Lee, Tao Okamoto",
                "Action, Adventure, Sci-Fi",
                "6.7",
                "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("6",
                "X-Men: Days of Future Past",
                "In the future, the mutants and the humans who help them are slaughtered by powerful robots named Sentinels. Professor Xavier, Wolverine, Magneto, Storm, Kitty Pryde, and her friends meet at a monastery in China and Xavier explains that the invincible Sentinels were created using the DNA of Mystique that was captured in 1973 when she tried to assassinate their creator Dr. Bolivar Trask. Xavier tells that their only chance is return to 1973 using Pryde's ability to join Charles Xavier and Erik Lehnsherr to convince Mystique to give up her intention. However, only Wolverine can withstand the damages of the time travel. Will he succeed in stopping Mystique and the Sentinel Program, and save the mutants and their human friends from annihilation?",
                "2014",
                "Patrick Stewart, Ian McKellen, Hugh Jackman",
                "Action, Adventure, Sci-Fi",
                "7.9",
                "https://m.media-amazon.com/images/M/MV5BZGIzNWYzN2YtMjcwYS00YjQ3LWI2NjMtOTNiYTUyYjE2MGNkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("7",
                "X-Men: Apocalypse",
                "Since the dawn of civilization, he was worshiped as a god. Apocalypse, the first and most powerful mutant from Marvel's X-Men universe, amassed the powers of many other mutants, becoming immortal and invincible. Upon awakening after thousands of years, he is disillusioned with the world as he finds it and recruits a team of powerful mutants, including a disheartened Magneto, to cleanse mankind and create a new world order, over which he will reign. As the fate of the Earth hangs in the balance, Raven with the help of Professor X must lead a team of young X-Men to stop their greatest nemesis and save mankind from complete destruction.",
                "2016",
                "James McAvoy, Michael Fassbender, Jennifer Lawrence",
                "Action, Adventure, Sci-Fi",
                "6.9",
                "https://m.media-amazon.com/images/M/MV5BMjU1ODM1MzYxN15BMl5BanBnXkFtZTgwOTA4NDE2ODE@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("8",
                "Logan",
                "In 2029 the mutant population has shrunken significantly due to genetically modified plants designed to reduce mutant powers and the X-Men have disbanded. Logan, whose power to self-heal is dwindling, has surrendered himself to alcohol and now earns a living as a chauffeur. He takes care of the ailing old Professor X whom he keeps hidden away. One day, a female stranger asks Logan to drive a girl named Laura to the Canadian border. At first he refuses, but the Professor has been waiting for a long time for her to appear. Laura possesses an extraordinary fighting prowess and is in many ways like Wolverine. She is pursued by sinister figures working for a powerful corporation; this is because they made her, with Logan's DNA. A decrepit Logan is forced to ask himself if he can or even wants to put his remaining powers to good use. It would appear that in the near-future, the times in which they were able put the world to rights with razor sharp claws and telepathic powers are now over.",
                "2017",
                "Hugh Jackman, Patrick Stewart, Dafne Keen",
                "Action, Drama, Sci-Fi",
                "8.1",
                "https://m.media-amazon.com/images/M/MV5BYzc5MTU4N2EtYTkyMi00NjdhLTg3NWEtMTY4OTEyMzJhZTAzXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MovieResponse("9",
                "X-Men: Dark Phoenix",
                "The X-Men. Protectors of peace. Jean Grey is one of the most beloved X-Men. But when a mission goes wrong, Jean is exposed to a dark and ancient power. This power has destroyed everything it comes in contact with, until her. Now that this power is becoming unstable, she releases it with destruction and anger. Now that this foreign power is consuming her, and the world is threatened, the X-Men have to face an important truth: they must save either the world, or their friend who threatens it.",
                "2019",
                "James McAvoy, Michael Fassbender, Jennifer Lawrence",
                "Action, Adventure, Sci-Fi",
                "5.8",
                "https://m.media-amazon.com/images/M/MV5BMmZmYTgwZGItNDIxMS00MmRkLWEzODQtYTllNzM0ZWE1NmQ5XkEyXkFqcGdeQXVyODQzNTE3ODc@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        return movies;
    }

    public static List<TVShowResponse> generateRemoteDummyTVShows(){
        ArrayList<TVShowResponse> tvShows = new ArrayList<>();

        tvShows.add(new TVShowResponse(
                "0",
                "Band of Brothers",
                "This is the story of \"E\" Easy Company, 506th Regiment of the 101st Airborne Division from their initial training starting in 1942 to the end of World War II. They parachuted behind enemy lines in the early hours of D-Day in support of the landings at Utah beach, participated in the liberation of Carentan and again parachuted into action during Operation Market Garden. They also liberated a concentration camp and were the first to enter Hitler's mountain retreat in Berchtesgaden. A fascinating tale of comradeship that is, in the end, a tale of ordinary men who did extraordinary things.",
                "Action, Drama, History",
                "2001",
                "Scott Grimes, Damian Lewis, Ron Livingston",
                "9.4",
                "https://m.media-amazon.com/images/M/MV5BMTI3ODc2ODc0M15BMl5BanBnXkFtZTYwMjgzNjc3._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "1",
                "The Wire",
                "Set in Baltimore, this show centers around the city's inner-city drug scene. It starts as mid-level drug dealer, D'Angelo Barksdale beats a murder rap. After a conversation with a judge, Det. James McNulty has been assigned to lead a joint homicide and narcotics team, in order to bring down drug kingpin Avon Barksdale. Avon Barksdale, accompanied by his right-hand man Stringer Bell, enforcer Wee-Bey and many lieutenants (including his own nephew, D'Angelo Barksdale), has to deal with law enforcement, informants in his own camp, and competition with a local rival, Omar, who's been robbing Barksdale's dealers and reselling the drugs. The supervisor of the investigation, Lt. Cedric Daniels, has to deal with his own problems, such as a corrupt bureaucracy, some of his detectives beating suspects, hard-headed but determined Det. McNulty, and a blackmailing deputy. The show depicts the lives of every part of the drug \"food chain\", from junkies to dealers, and from cops to politicians.",
                "Crime, Drama, Thriller",
                "2002-2008",
                "Dominic West, Lance Reddick, Sonja Sohn",
                "9.3",
                "https://m.media-amazon.com/images/M/MV5BZmY5ZDMxODEtNWIwOS00NjdkLTkyMjktNWRjMDhmYjJjN2RmXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "2",
                "Avatar: The Last Airbender",
                "The world is divided into four elemental nations: The Northern and Southern Water Tribes, the Earth Kingdom, the Fire Nation, and the Air Nomads. The Avatar upholds the balance between the nations, but everything changed when the Fire Nation invaded. Only the Avatar, master of all four elements, can stop them. But when the world needs him most, he vanishes. A hundred years later Katara and Sokka discover the new Avatar, an airbender named Aang. Together they must help Aang master the elements and save the world.",
                "Animation, Action, Adventure",
                "2005-2008",
                "Zach Tyler, Mae Whitman, Jack De Sena",
                "9.2",
                "https://m.media-amazon.com/images/M/MV5BODc5YTBhMTItMjhkNi00ZTIxLWI0YjAtNTZmOTY0YjRlZGQ0XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "3",
                "Life",
                "David Attenborough's legendary BBC crew explains and shows wildlife all over planet earth in 10 episodes. The first is an overview of the challenges facing life, the others are dedicated to hunting, the deep sea and various major evolutionary groups of creatures: plants, primates and other large sections of other vertebrates and invertebrates.",
                "Documentary",
                "2009",
                "Oprah Winfrey, David Attenborough",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BNjJhMTAxZjYtNWZkYy00Nzg1LTlkYjItZTNhZWRjNzkxMDg3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR3,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "4",
                "Fullmetal Alchemist: Brotherhood",
                "Two brothers lose their mother to an incurable disease. With the power of \"alchemy\", they use taboo knowledge to resurrect her. The process fails, and as a toll for using this type of alchemy, the older brother, Edward Elric loses his left leg while the younger brother, Alphonse Elric loses his entire body. To save his brother, Edward sacrifices his right arm and is able to affix his brother's soul to a suit of armor. With the help of a family friend, Edward receives metal limbs - \"automail\" - to replace his lost ones. With that, Edward vows to search for the Philosopher's Stone to return the brothers to their original bodies, even if it means becoming a \"State Alchemist\", one who uses his/her alchemy for the military.",
                "Animation, Action, Adventure",
                "2009-2012",
                "Kent Williams, Iemasa Kayumi, Vic Mignogna",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BZmEzN2YzOTItMDI5MS00MGU4LWI1NWQtOTg5ZThhNGQwYTEzXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR4,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "5",
                "Sherlock",
                "In this modernized version of the Conan Doyle characters, using his detective plots, Sherlock Holmes lives in early 21st century London and acts more cocky towards Scotland Yard's detective inspector Lestrade because he's actually less confident. Doctor Watson is now a fairly young veteran of the Afghan war, less adoring and more active.",
                "Crime, Drama, Mystery",
                "2010-2017",
                "Benedict Cumberbatch, Martin Freeman, Una Stubbs",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BMWY3NTljMjEtYzRiMi00NWM2LTkzNjItZTVmZjE0MTdjMjJhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTQ4NTc5OTU@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "6",
                "Planet Earth",
                "Each 50 minute episode features a global overview of a different biome or habitat on Earth (Polar, Mountain, Cave, Desert, Plains, Fresh Water, Seas, Ocean, Forest), followed by a ten-minute featurette which takes a behind-the-scenes look at the challenges of filming the episode.",
                "Documentary",
                "2006",
                "David Attenborough, Sigourney Weaver, Thomas Anguti Johnston",
                "9.4",
                "https://m.media-amazon.com/images/M/MV5BNmZlYzIzMTItY2EzYS00YTEyLTg0ZjEtMDMzZjM3ODdhN2UzXkEyXkFqcGdeQXVyNjI0MDg2NzE@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "7",
                "Game of Thrones",
                "In the mythical continent of Westeros, several powerful families fight for control of the Seven Kingdoms. As conflict erupts in the kingdoms of men, an ancient enemy rises once again to threaten them all. Meanwhile, the last heirs of a recently usurped dynasty plot to take back their homeland from across the Narrow Sea.",
                "Action, Adventure, Drama",
                "2011-2019",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                "9.3",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_UY268_CR7,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "8",
                "Persona (Sahsiyet)",
                "Agâh is a retired 65-year-old judicial clerk, who crosses roads with Nevra, the only female police officer in the homicide office. Is it only a coincidence that Agâh and Nevra approach each other? Agâh Beyoglu, a retired judicial officer, is living alone in Beyoglu, Istanbul's most populous and lively district. His daughter lived abroad, his wife died years ago. This monotonous life of Agâh is upset by the diagnosis of Alzheimer's beginning. He will forget all his memories because of his illness. Even if we do not accept this fact at first, Agâh realizes that forgetting is an opportunity. An opportunity to commit a murder he has planned for years. He will not remember this crime in the future and he will not take remorse for not remembering it. Meanwhile, Nevra, the female police officer in the murder desk, was on the verge of resignation because of the pressure on her. However, the murder decision of Agâh will completely change the life of Nevra.",
                "Crime, Drama, Mystery",
                "2018",
                "Haluk Bilginer, Cansu Dere, Metin Akdülger",
                "9.1",
                "https://m.media-amazon.com/images/M/MV5BOTJkNzJmYzgtZTZmNC00MTQ2LWE2ZGQtM2EyYjliNGViMTY5XkEyXkFqcGdeQXVyNDg4MjkzNDk@._V1_UY268_CR4,0,182,268_AL_.jpg"
        ));

        tvShows.add(new TVShowResponse(
                "9",
                "Batman: The Animated Series",
                "Heir to the Wayne family fortune, Bruce Wayne (Kevin Conroy) lives by day as a seemingly lavish playboy millionaire socialite, but by night assumes the role of his crime-fighting alter-ego: the caped crusader known as Batman. Throughout the show, Batman receives help from sidekicks Robin (Loren Lester) and Batgirl (Melissa Gilbert), as well as Police Commissioner Gordon (Bob Hastings), in protecting the streets of Gotham City from a large rogue's gallery of criminals, lunatics, and nemeses.",
                "Animation, Action, Adventure",
                "1992-1995",
                "Kevin Conroy, Loren Lester, Efrem Zimbalist Jr.",
                "9.0",
                "https://m.media-amazon.com/images/M/MV5BOTM3MTRkZjQtYjBkMy00YWE1LTkxOTQtNDQyNGY0YjYzNzAzXkEyXkFqcGdeQXVyOTgwMzk1MTA@._V1_UX182_CR0,0,182,268_AL_.jpg"
        ));
        return tvShows;
    }
}
