--AUTHORS
INSERT INTO AUTHORS (name, rating, date_of_birth, photo_url, bio) VALUES ('Robert C. Martin', 4.8, '1952-01-01', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Robert_Cecil_Martin.png/800px-Robert_Cecil_Martin.png', 'Bob bácsi néven ismert, amerikai szoftverkonzulens és szerző. Martin professzionális szoftverfejlesztő 1970 óta és nemzetközi szoftverkonzulens 1990 óta. 2001-ben életre hívott egy csoporttalálkozót, amely megalkotta az agilis szoftverfejlesztést az extrém programozási technikákból[2]. Továbbá kulcsfontosságú tagja a szoftver szaktudás mozgalomnak. Ő alapította az Object Mentor Inc.-et,[3] azt a konzultációs céget, amely a C++, Java, OOP, tervezési minták, UML, agilis módszertanok és extrém programozás oktatására specializálta magát. 1996-tól 1999-ig ő volt a főszerkesztője a C++ Report-nak. 2002-ben írta Agilis szoftverfejlesztés: alapelvek, minták és gyakorlat, mely gyakorlati tanácsokat ad agilis csoportoknak objektumorientált tervezés és fejlesztés területén. Számos népszerű könyvet és cikket publikált a programozásról és a szoftver módszertanokról.');
INSERT INTO AUTHORS (name, rating, date_of_birth, photo_url, bio) VALUES ('Petőfi Sándor', 3.6, '1823-01-01', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Barab%C3%A1s_Pet%C5%91fi.jpg/800px-Barab%C3%A1s_Pet%C5%91fi.jpg', 'Petőfi Sándor (született Petrovics, Kiskőrös, 1823. január 1. [keresztelés dátuma] – Fehéregyháza, 1849. július 31.) magyar költő, forradalmár, nemzeti hős, a magyar költészet egyik legismertebb és legkiemelkedőbb alakja. Rövid élete alatt közel ezer verset írt magyarul, ebből körülbelül nyolcszázötven maradt az utókorra, és az ismertebbeket sok más nyelvre lefordították.[2] A tanulást 18 éves korában abbahagyva színész lett, és ekkor kezdett verseket írni. 1844-től élt Pesten, 1846-tól baráti körével irodalmi társaságot szervezett. Fiatal kora ellenére ekkorra már országos ismertségre tett szert. A „márciusi ifjak” egyik vezetőjeként részt vett az 1848. március 15-i forradalomban, amelynek a szimbólumává vált. A 26 éves költő ezután a szabadságharc küzdelmeiben is részt vállalt. A történészek mai álláspontja szerint életét is áldozta a magyar szabadságért, hiszen 1849. július 31-én esett el a segesvári csatát követő fejvesztett menekülés közben, a honvédeket üldöző kozák ulánusok által elkövetett mészárlásban. Eltűnésének minden körülménye azonban még a mai napig sem tisztázódott. Ő a magyar romantika kiteljesítője, és koráig még ismeretlen témákat honosított meg a magyar költészetben: nála jelent meg először a családi líra, szerelmi költeményeiben a hitvesi, házastársi szerelem ábrázolása, tájköltészetében pedig a „puszta”, a magyar Alföld méltó rajza. Ő írt először verseiben a „világszabadságról”, és általa teljesen új hang szólalt meg a magyar irodalomban. Közérthetően, egyszerűen szólt mindenkihez, hiszen a nép nyelvét beemelte az irodalomba, és a versek külső formája helyett a gondolatot állította középpontba. Számos költeménye szinte minden magyar számára ismert. János vitéz című elbeszélő költeményéből daljáték, bábelőadás, rajzfilm és rockopera is készült. Legismertebb költeménye a Nemzeti dal, amely az 1848. március 15-i forradalom máig ható üzenete és a magyar hazafias költészet kiemelkedő alkotása. Emlékét Magyarországon és a Kárpát-medence magyarlakta helységeiben több múzeum és emlékház, valamint számtalan utcanév, szobor és emléktábla őrzi. ');
INSERT INTO AUTHORS (name, rating, date_of_birth, photo_url, bio) VALUES ('Jamie Oliver', 3.3, '1975-05-27', 'https://www.nosalty.hu/files/nosalty_kepek/11924897_10153288286219807_9131980940113578524_n.jpg', 'Egy kis essexi faluban, Claveringben nőtt fel. Szüleinek egy The Cricketters nevű pubja volt. 1989-ben Leigh Haggerwooddal együtt megalapította a Scarlet Division nevű együttest. 16 évesen elvégezte a Westminster Catering College-ot. Néhány évet a híres londoni szakács, Gennaro Contaldo mellett töltött, akit egyik kulináris mentorának tekintett. Az első munkája a Antonio Carluccio''s Neal''s Yard étteremben, ahol a tésztákat készítette. Ezután Oliver a The River Café (Fulham) sous chef-je lett. Először 1996-ban egy dokumentumműsorban szerepelt, melynek címe Christmas at the River Café volt. Llewellyn televíziós producer ekkor fedezte fel. 2000. június 24-én elvette Juliette Nortont, ismertebb nevén Joolst. A párnak három lánya és egy fia van, Poppy Honey (2002. március 18.), Daisy Boo (2003. április 10.), Petal Blossom Rainbow (2009. április 3.) és Buddy Bear Maurice (2010. szeptember 15.). A család Clavering-ben (Essex) él. 2003 júniusában a Brit Birodalom rendjének tagjává ütötték. Felállította a Fifteen jótékonysági éttermet, ahol 15 hátrányos helyzetű fiatalnak adott álláslehetőséget a vendéglátóiparban. Szándékai szerint országszerte, valamint Sydney és New York területén is állít fel ilyen helyeket. ');

--BOOKS
INSERT INTO BOOKS (title, author_id, isbn, number_of_pages, publicated_by, publication_year, rating, photo_url, description) VALUES ('Tiszta kód - Az agilis szoftverfejlesztés kézikönyve', 1, '9789639637696', 466, 'Kiskapu Kft.', 2010, 5.0, 'https://marvin.bline.hu/product_images/847/B867872.JPG', 'A rossz kód is működhet, de ha a kód nem tiszta, az térdre kényszerítheti a fejlesztőket. Évente számtalan óra és jelentős erőforrások vesznek kárba a rosszul megírt kódok miatt. Ennek azonban nem feltétlenül kell így lennie. Az elismert szoftverszakértő, Robert C. Martin egy forradalmi módszert mutat be a Tiszta kód - Az agilis szoftverfejlesztés kézikönyve című kötetében. Martin és kollégái az Object Mentor cégnél összefogtak, hogy az agilis programfejlesztés legjobb „menet közbeni” kód-kitisztítási eljárásait egy olyan könyvben gyűjtsék össze, amely felruház minket mindazokkal a szakmai erényekkel, amelyek révén jobb programozóvá válhatunk – de csak akkor, ha mi is teszünk érte. Miféle munkát fogunk végezni? Nos, kódot fogunk olvasni - rengeteg kódot. És el kell gondolkodnunk rajta, hogy mi az, ami jó a kódban, és mi az, ami rossz. Ami pedig ennél is fontosabb: át kell értékelnünk mindazt, amit a szakmáról tudunk, és a szakma iránt érzett elkötelezettségünket. A Tiszta kód három részre oszlik. Az első a tiszta kód írásához szükséges alapelveket, mintákat és eljárásokat mutatja be. A második részben számos, egyre összetettebb esettanulmányt találhatunk. Minden esettanulmány a kód kitisztításának egy-egy módját szemlélteti – hibás kódokat fogunk egészséges és hatékony kódokká alakítani. A harmadik rész a jutalom: egyetlen fejezetből áll, amely azokat az árulkodó jeleket és „szagokat” sorolja fel, amelyeket a szerző és társai az esettanulmányok összeállítása során gyűjtöttek össze. Az eredmény egy olyan tudásalap, amely leírja, hogyan gondolkodjunk, amikor kódot írunk, olvasunk és tisztítunk.');
INSERT INTO BOOKS (title, author_id, isbn, number_of_pages, publicated_by, publication_year, rating, photo_url, description) VALUES ('Túlélőkönyv programozóknak - Hogyan váljunk igazi szakemberré?', 1, '9789639637863', 208, 'Kiskapu Kft.', 2011, 3.8, 'https://marvin.bline.hu/product_images/76/B982136.JPG', '„Bob bácsi” sikerkönyve, a Tiszta kód várva-várt folytatása azoknak a programozóknak, akiket nem rettent el a bizonytalanság, és sikerrel állják a folyamatos nyomást, van egy közös erényük: mélyen tisztelik, és komoly szakmának tekintik a szoftverfejlesztést. Egy szóval: profik. Clean coder: Irányelvek hivatásos programozóknak Robert C. Martin, a legendás szoftverszakértő legújabb könyve, amelyben a szerző azt mutatja be, hogyan kell viselkednie, milyen eljárásokat kell követnie, és milyen eszközöket kell használnia annak, aki valóban profi programozóvá szeretne válni. A kötet tele van gyakorlati tanácsokkal, az egy-egy munkához szükséges idő megbecslésétől a kódoláson keresztül az újratervezésig és a tesztelésig, de nem pusztán a technikáról szól: sokkal inkább a hozzáállásról. Martin megmutatja, hogyan lehet a szoftverfejlesztést becsülettel, önbecsüléssel és büszkeséggel megközelíteni; hogyan kell jól és tisztán dolgozni; őszintén kommunikálni, becsülni és nehéz döntéseket meghozni; és megérteni, hogy a szaktudással együtt jár a cselekvés felelőssége is.
<p>- A könyvet elolvasva a következőket tanulhatjuk meg: Hogyan viselkedik egy valóban profi szoftverfejlesztő?</p>
<p>- Hogyan kezelhetjük a konfliktusokat, a szoros határidőket és az ésszerűtlen döntéseket hozó feletteseket?</p>
<p>- Hogyan juthatunk túl az írói válságon, és lendülhetünk bele a kódolásba?</p>
<p>- Hogyan kezelhetjük a szüntelen nyomást, és kerülhetjük el a kiégést?</p>
<p>- Hogyan egyeztethetjük össze a bevált megoldásokat az új fejlesztési megközelítésekkel?</p>
<p>- Hogyan osszuk be az időnket, és kerüljük el a vakvágányokat és ingoványos területeket?</p>
<p>- Hogyan alakíthatunk ki a programozók és csapatok számára ösztönző környezetet?</p>
<p>- Mikor mondjunk nemet – és hogyan?</p>
<p>- Mikor mondjunk igent – és mit jelent valójában az „igen”?</p> A jó szoftverben gyönyörködni lehet, mert sokoldalú, elegáns, praktikus, és fejlesztőként és felhasználóként egyaránt öröm vele dolgozni. A jó szoftvert nem gépek készítik, hanem hivatásos, profi programozók, akik megingathatatlan elkötelezettséget éreznek a szakmájuk iránt. A Clean coder segít, hogy mi is igazi profivá váljunk, és azt a büszkeséget és elégedettséget érezzük, ami csak egy profinak jut osztályrészül.');
INSERT INTO BOOKS (title, author_id, isbn, number_of_pages, publicated_by, publication_year, rating, photo_url, description) VALUES ('János vitéz', 2, '9789631186086', 118, 'Móra Könyvkiadó', 2014, 3.4, 'https://marvin.bline.hu/product_images/766/B84047.JPG', 'Petőfi Sándor ezen elbeszélő költeménye olyan, mintha népmese lenne, csak éppen versben előadva. Petőfi János vitéz és Iluska sorsán keresztül igazságot is szolgáltat, de művében a magyar nép vágyát is megfogalmazta. Majd száz évvel később egy másik magyar író, Szerb Antal mondta: " A János vitéz az, amit az ember szeretne odaajándékozni külföldi ismerőseinek, hogy megérezzék a magyar népjelleg melegségét, humorát, semmihez sem fogható báját, hogy megérezzék a magyar szív verését. Ebben a műben csodálatosan együtt van a magyar föld valósága és a magyar lélek álma."');
INSERT INTO BOOKS (title, author_id, isbn, number_of_pages, publicated_by, publication_year, rating, photo_url, description) VALUES ('A hóhér kötele', 2, '9799639331036', 168, 'Dekameron', 2002, 4.8, 'https://marvin.bline.hu/product_images/959/2000000577770.JPG', 'A kötetben Petőfi Sándor - oktatási anyagként is kiemelten ajánlott - izgalmas, gördülékeny és olvasmányos regényét olvashatjuk. Petőfi prózája és e pompás mű éppoly időtálló és kiemelten jelentős kincse irodalmunknak, mint versei. A Petőfi kép teljességéhez e regény megismerése nélkülözhetetlen.');
INSERT INTO BOOKS (title, author_id, isbn, number_of_pages, publicated_by, publication_year, rating, photo_url, description) VALUES ('Jamie 30 percesek - Finom ételek villámgyorsan - Jamie vadonatúj módszere', 3, '9789633550199', 288, 'Park Kiadó', 2013, 2.2, 'https://marvin.bline.hu/product_images/152/B1081623.JPG', '"Megmutatom, hogyan készíthetsz el egy teljes menüt röpke 30 perc alatt! Nemcsak egy ételt, hanem egy komplett ebédet vagy vacsorát!" Ha te is annyira szeretsz főzni, mint én, és a fárasztó munkanap végén még éhes szájakról kell gondoskodnod, engedd, hogy megismertessem veled ezt a teljesen új módszert. Könyvemben megmutatom, hogyan lehetséges egy többfogásos étkezést megfőzni annyi idő alatt, amennyit eddig egyetlen ételre fordítottál. Ígérem, szemed-szád eláll, ha meglátod, mire vagy képes 30 perc alatt. Az enyém elállt, az biztos! Nem arról van szó, hogy engedj a minőségből. A lényeg, hogy szervezd meg a munkát, dolgozz gyorsan, és vess be ügyes mesterfogásokat – így szinte pillanatok alatt észbontóan finom ételeket tudsz az asztalra varázsolni. A 30 percesekben olvasható 50 ételsor mindegyikének leírása lényegre törő: semmi hókuszpókusz, csak lendületes, gyors főzés. A menüket úgy állítottam össze, hogy az egyes ételek jól passzoljanak egymáshoz; a receptek könnyen követhetők. A főzésnek ez a módszere arról szól, hogy célirányosan használjunk ki minden percet, érezzük jól magunkat, és a konyha nyerje vissza végre azt a funkcióját, amire kitalálták. Lehet, hogy most beléd villan: ilyen nincs, de én garantálom, hogy lehetséges. Lapozz bele, hogy lásd, milyen életsorokat fogsz megalkotni. Ha egyszer elkezdesz így főzni, nemcsak hogy imádni fogod: sose főzöl többé a régi módon!');

--USERS
INSERT INTO USERS (email, password, full_name) VALUES ('admin@test.com', 'pwd', 'Test Admin'); -- ADMIN
INSERT INTO USERS (email, password, full_name) VALUES ('user@test.com', 'pwd', 'Test User');
INSERT INTO USERS (email, password, full_name) VALUES ('gyula@test.com', 'pwd', 'Keresztes Gyula');
INSERT INTO USERS (email, password, full_name) VALUES ('jakab@test.com', 'pwd', 'Gipsz Jakab');
INSERT INTO USERS (email, password, full_name) VALUES ('manyi@test.com', 'pwd', 'Harap Magdolna');
INSERT INTO USERS (email, password, full_name) VALUES ('sonka@test.com', 'pwd', 'Sonka Szelet');
INSERT INTO USERS (email, password, full_name) VALUES ('sonkasz@test.com', 'pwd', 'Sonka Szabolcs');
INSERT INTO USERS (email, password, full_name) VALUES ('samu@test.com', 'pwd', 'Salamon Katalin');
INSERT INTO USERS (email, password, full_name) VALUES ('jancsi@test.com', 'pwd', 'Gipsz Jancsi');
INSERT INTO USERS (email, password, full_name) VALUES ('pacal@test.com', 'pwd', 'Rágós Pacal');

-- ROLES
INSERT INTO ROLES (role) VALUES ('USER');
INSERT INTO ROLES (role) VALUES ('ADMIN');
--USERS_ROLES
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (1, 2); -- ADMIN
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (2, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (3, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (4, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (5, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (6, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (7, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (8, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (9, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES (10, 1);

-- CONTACT MESSAGES
INSERT INTO CONTACT_MESSAGES (from_email, from_name, is_readed, message) VALUES ('user@test.com', 'Test User', false, 'Hey there! I got some great news for you! I would like to invest to your company! Contact me ASAP!');
INSERT INTO CONTACT_MESSAGES (from_email, from_name, is_readed, message) VALUES ('jancsi@test.com', 'Hadnagy Jancsi', true, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');
INSERT INTO CONTACT_MESSAGES (from_email, from_name, is_readed, message) VALUES ('loremipsum@test.com', 'Lorem Ipsum Dolor', false, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et tellus viverra, vestibulum magna sed, tempor mi. Vivamus eu tortor luctus, varius velit vitae, viverra eros. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. In non ex purus. Mauris nec magna augue. Nullam risus libero, porttitor sit amet erat varius, pulvinar tristique nulla. Aliquam eget leo sit amet dolor consequat aliquam in ut tellus. Nunc a lobortis libero. Nulla tincidunt consequat iaculis. Phasellus id metus at mauris interdum ullamcorper sed vel massa. Curabitur efficitur at nulla sit amet ultrices. Mauris dapibus enim et commodo sodales. Suspendisse ac est ut erat venenatis consequat. In nisl enim, pulvinar a dapibus vitae, ultricies id lorem. Duis tempus orci eu quam tempus, quis bibendum eros fringilla. Nulla luctus orci sit amet nisl auctor sollicitudin. Phasellus bibendum laoreet vulputate. Sed in sagittis diam, sed dapibus augue. Duis hendrerit, diam eu congue lacinia, urna nibh interdum dolor, eu eleifend est nisl in ex. Etiam malesuada ac tellus et semper. Sed at bibendum neque. Nunc rutrum nisi vel mauris finibus, eget imperdiet augue faucibus. Suspendisse fringilla auctor blandit. Sed mauris nisl, pharetra sed dapibus non, placerat et dolor. Quisque maximus vel purus et bibendum. Nunc velit justo, consectetur nec luctus et, viverra vel erat. Aliquam erat volutpat. Sed rhoncus ipsum velit. Nunc posuere fermentum dolor, id hendrerit eros efficitur nec. Fusce ut ultricies justo. Proin interdum mauris ante. Donec laoreet enim mauris, sed volutpat tortor volutpat nec. Maecenas lobortis malesuada ligula, ut rhoncus mi. Integer ultrices, sapien eget eleifend pulvinar, ipsum nibh scelerisque tortor, vitae rutrum elit sem quis justo. Maecenas molestie ligula in nunc feugiat fringilla. Ut dapibus arcu elit, non venenatis lacus convallis sit amet. Cras feugiat ac magna a tincidunt. Donec consequat libero diam, sit amet eleifend nisl lacinia ut. Sed vulputate ullamcorper dui et iaculis. Etiam consequat varius dolor quis malesuada. Nunc feugiat metus sit amet cursus pretium. Nunc sit amet velit dapibus, eleifend ante ac, sodales dui. Donec accumsan felis vitae libero ornare sagittis. Phasellus lacus ante, dignissim sit amet leo a, ultrices mollis dolor. Morbi quis purus fringilla, sagittis mauris id, ultrices dui. Pellentesque in nisl lacus. Etiam iaculis tempus mi ac posuere. Aliquam erat volutpat. Nullam ullamcorper risus id enim vehicula, rhoncus posuere dui suscipit. Phasellus euismod, est porta semper suscipit, tortor felis pulvinar dui, pretium ullamcorper neque nulla id erat. Duis id tellus congue, laoreet ex ac, fermentum orci. Pellentesque porttitor condimentum ligula, sed porttitor dui gravida nec. Phasellus vitae nibh et arcu lobortis placerat nec id ex. Nullam quis maximus ligula.');
