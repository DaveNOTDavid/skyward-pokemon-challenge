# Skyward Pokemon Challenge
As instructed in the [prompt](https://gist.github.com/adamshick-Skyward/61cd42e450e192939e31026bec97feee), a list of Pokemon cards (fetched from the [API](https://docs.pokemontcg.io/api-reference/cards/search-cards)) will be displayed in a grid UI with each being tappable to take the user to another screen to view the selected card in more detail (via another [call](https://docs.pokemontcg.io/api-reference/cards/get-card)). The project uses most of the new Android technologies and architecture components including, **but not limited to**:
- MVVM (with `ViewModel` and `LiveData`) 
- Data/View Binding
- Navigation component with fragments 
- Hilt DI 
- Kotlin Coroutines
- Retrofit/Okhttp

Demo:

![alt tag](https://media.giphy.com/media/GyNsv4MCrosCsZRKHA/giphy.gif)
