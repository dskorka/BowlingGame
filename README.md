# Dobre praktyki podczas tworzenia oprogramowania

##### Założenia ogólne
- W nazwach unikamy obsługi technicznej np. "getMessageWhenThrowException"
- Korzystamy z odpowiednich nazw, które przedstawiają intencje
- Nie używamy System.out.println() w aplikacji
- Jeżeli w danym fragmencie kodu występuje problem, to pracujemy nad nim do czasu gdy zostanie naprawiony - "sekwencyjna realizacja algorytmu"
- Zasada SOLID:
	***S**ingle responsibility principle(zasada pojedyńczej odpowiedzialności) - dany kawałek kodu ma tylko jedną odpowiedzialność
	***O**pen/closed principle(zasada otwarte-zamknięte) - otwarty na rozszerzenie, zamknięty na modyfikację. Przy zmianie wymagań nie powinien być zmieniany stary działający kod, ale dodawany nowy który rozszeża zachowania.
	***L**iskov substitution principle(dziedziczenie zachowania a nie pól) - klasy nie dziedziczą struktór danych. Dziedziczymy metody, które możemy modyfikować poprzez stosowanie interfejsów.
	***I**nterface segregation principle(zasada segregacji interfejsów) - interfejs udostępnia tylko niezbedne metody
	***D**ependency inversion principle(zasada odwrócenia zależności) - wstrzykiwanie zależności. Moduły wysokopoziomowe nie powinny zależeć od modułów nisko poziomowych, np. usługi zapisującej nie interesuje jak dane zostają zapisane i gdzie. 
- 


##### Tworzenie kodu

- Tworzony kod ma obsługiwać dokładnie to co jest założone w specyfikacji
- Metoda nie może zmieniać wartości, która została jej przekazana
- Metoda wykonuje tylko jedną czynność
- W klasie oddzielamy główny kod od spraw technicznych. W głownej metodzie znajduje się algorytm/idea działania natomiast w metodach pomocniczych odbywa się realizacja poszczegółnego kroku algorytmu
- Jeżeli jest to możliwe nie korzystamy z negacji "!", ponieważ jest trudna do zauważenia. Jeśli jednak jest użyta, należy ją wypuklić spacjami
- Nazwy klas mają rzeczowniki
- Nazwy metod mają czasowniki
- Nazwy muszą konkretnie określać czym się zajmują
- Bezstanowe repozytorium - nie przechowuje stanu wewnętrznego
- Wszystkie zmiany w bazie danych są tworzone przez skrypt migrujący
- Każda metoda powinna być komendą(command) lub zapytaniem(query) ale nigdy jednocześnie komendą i zapytaniem - zasada CQS
	*command - akcja(czasownik) której efektem jest zmiana jakiegoś stanu. Nie zwraca wartości
	*query - zwrócenie danych
- W kodzie produkcyjnym nie tworzymy metod na potrzeby testów



##### Testy
- Nazwa klasy testowej zaczyna się od słowa "should" a słowa w nazwie oddzielane są podkreśleniem dolnym "_"
- Ddzwierciedlają potrzebę biznesową
- Objemują wszystkie ważniejsze zmiany w kodzie
- Poszczególny test sprawdza jedną regułę/algorytm
- Nazwa testu odzwierciedla co dany test sprawdza
- Testy muszą się uruchamiać niezależnie od siebie, pojedyńczo, w różnej kolejności lub wszystkie naraz
- Test dzielimy na trzy bloki: 
	* given - sekcja w której tworzymy założenia początkowe
	* when - w tej sekcji wykonujemy akcję którą chcemy testować
	* then - wykonujemy sprawdzenia czy testowany kod zachowuje się zgodnie z oczekiwaniami
- Nie stosujemy wartości statycznych
- Jeżeli testowana funkcjonalność korzysta z zewnętrznych modułów należy zastąpić je atrapą (mock). Atrapa wykorzystywana jest tylko i wyłącznie w teście, której celem jest symulacja zachowania prawdziwej zależności w oparciu o dane wyjściore które definiujemy. Nazwy klas implementującej atrapy (wydmuszki) muszą zawietrać słowo "Mock"

- Przy tworzeniu testów wykorzystujemy technikę TDD(technika pisania kodu stymulowana przez testy):
	* Napisz test - dodanie każdej nowej funkcjonalności zaczyna się od napisania testu, które w tym momencie nie przechodzą ze względu na brak zaimplementowanych funkcjonalności
	* Implementuj funkcjonalność - po zaimplementowaniu odpowiednich metod wcześniej przygotowany test przechodzi pozytywnie.
	* Refaktoruj kod - wprowadzamy zmiany, które poprawiają jakoś kodu ale nie zmieniają jego funkcjonalności

##### System kontroli wersji - Git
- Wykonujemy częste i małe commity - nie kisimy kodu
- Commit wykonujemy jedynie wtedy, gdy kod kompiluje się i przechodzi testy
- Do repozytorium nie przesyłamy plików konfiguracyjnych IDE, jedynie te które są ściśle związane z projektem
- Pracujemy w trybie Rebase - polega na zamianie podstawy (branch jest liniowa)