# LumusLogicTask

A simple Android app fetching news articles using MVVM Clean Architecture, Jetpack Compose, Room, Paging, Hilt.

## Setup Instructions
1. Clone the repo.
2. Add `apiKey=YOUR_NEWSAPI_KEY` to build.gradle.
3. Sync Gradle and run the app.

## Architecture Overview
- MVVM with Clean Architecture: UI (Compose), Presentation (ViewModels), Domain (UseCases, Models), Data (Repository, Local/Remote).
- Layers separated for scalability.

## Key Decisions and Trade-offs
- Used Paging 3 with RemoteMediator for pagination and offline cache (caches last successful pages).
- NewsAPI for data; key via BuildConfig.
- Trade-off: Simple cache (replace on refresh) vs full offline paging; chose simple for demo.

## Known Limitations
- Assumes US news; extendable.
