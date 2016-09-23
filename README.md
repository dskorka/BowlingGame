# Dobre praktyki podczas tworzenia oprogramowania

###### Założenia ogólne
- W nazwach unikamy obsługi technicznej np. "getMessageWhenThrowException"
- Korzystamy z odpowiednich nazw, które przedstawiają intencje
- Nie używamy System.out.println() w aplikacji
- Jeżeli w danym fragmencie kodu występuje problem, to pracujemy nad nim do czasu gdy zostanie naprawiony - "sekwencyjna realizacja algorytmu"






###### Tworzenie kodu

- Tworzony kod ma obsługiwać dokładnie to co jest założone w specyfikacji
- Metoda nie może zmieniać wartości, która została jej przekazana
- Metoda wykonuje tylko jedną czynność
- W klasie oddzielamy główny kod od spraw technicznych. W głownej metodzie znajduje się algorytm/idea działania natomiast w metodach pomocniczych odbywa się realizacja poszczegółnego kroku algorytmu
- Jeżeli jest to możliwe nie korzystamy z negacji "!", ponieważ jest trudna do zauważenia. Jeżeli jej używamy to należy ją wypuklić spacjami
- Nazwy klas mają rzeczowniki
- Nazwy metod mają czasowniki
- Bezstanowe repozytorium - nie przechowuje stanu wewnętrznego
- Wszystkie zmiany w bazie tworzone są przez skrypt migrujący



###### Testy
- Nazwa klasy testowej zaczyna się od słowa "should" a słowa w nazwie oddzielane są podkreśleniem dolnym "_"
- Testy powinny obejmowac wszystkie wazniejsze zmiany w kodzie

##### Git
- Wykonujemy częste commity - nie kisimy kodu
- Commit wykonujemy jedynie wtedy, gdy kod kompiluje się i przechodzi testy