# NewsApp

Aplicación Android de noticias hecha con Jetpack Compose y Retrofit. Las noticias se obtienen de [NewsAPI](https://newsapi.org/).

## Clave de la API

La clave no va en el código ni en Git. Gradle la lee de un archivo local `secrets.properties` (ignorado por Git) y la inyecta en `BuildConfig.NEWS_API_KEY` al compilar.

1. Regístrate y crea una clave en [https://newsapi.org/register](https://newsapi.org/register).
2. En la raíz del proyecto, copia el ejemplo:

   ```bash
   cp secrets.properties.example secrets.properties
   ```

3. Abre `secrets.properties` y sustituye el valor de ejemplo por tu clave:

   ```properties
   NEWS_API_KEY=tu_clave_de_newsapi
   ```

4. Compila el proyecto con normalidad. Sin ese archivo, o si dejas el valor de ejemplo, la compilación se detiene a propósito.

No subas `secrets.properties`. Si una clave llegó a publicarse, revócala en NewsAPI y usa una nueva solo en ese archivo local.
