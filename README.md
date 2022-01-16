# Skyward Pokemon Challenge
The project uses most of the new Android technologies and architecture components including, **but not limited to**:
- MVVM (with `ViewModel` and `LiveData`) 
- Data/View Binding
- Navigation component with fragments 
- Hilt DI 
- Kotlin Coroutines
- Retrofit/Okhttp

A list of Pokemon cards (fetched from the [API](https://docs.pokemontcg.io/api-reference/cards/search-cards)) are initially displayed in a grid UI with each being tappable to take the user to another screen to view the selected card in more detail (via another [call](https://docs.pokemontcg.io/api-reference/cards/get-card)).

Demo:

![alt tag](https://media.giphy.com/media/GyNsv4MCrosCsZRKHA/giphy.gif)
