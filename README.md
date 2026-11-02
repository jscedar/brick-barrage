# Brick Barrage

An aim-and-shoot brick breaker built for the Fire TV remote. Aim your volley, break the numbered bricks, and grab the rings for extra balls before the wall reaches the line.

## Controls

| Remote | Action |
| --- | --- |
| ◀ ▶ | Aim |
| ▲ or OK (centre) | Fire, and start a game |
| ▼ | Recall balls |
| ▲, OK or Play/Pause during a shot | Speed up |
| Back | Exit |


## Install on Fire TV

1. On the Fire TV, open **Settings → My Fire TV → About** and click the device name 7 times to unlock Developer options.
2. Install the **Downloader** app from the Amazon Appstore.
3. In **Settings → My Fire TV → Developer options → Install unknown apps**, turn on Downloader.
4. Open Downloader and enter:

   ```
   https://github.com/jscedar/brick-barrage/releases/latest/download/BrickBarrage.apk
   ```

5. Choose **Install**. Brick Barrage appears in your apps list.

Each push to `main` builds a new APK automatically and publishes it as the latest release, so the link above always gets the newest version. Updates install over the old version without losing your best score.

## Project layout

- `app/src/main/assets/index.html`: the whole game (HTML canvas)
- `app/src/main/java/.../MainActivity.java`: full-screen WebView that maps the remote's buttons to the game
- `.github/workflows/build.yml`: builds and publishes the APK

The signing key in `app/release.keystore` is included on purpose so every build can update the previous install. It is only for this hobby game; don't reuse it for anything else.
