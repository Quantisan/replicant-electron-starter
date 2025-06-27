# Electron + Shadow-CLJS + Replicant Starter

A minimal Electron application starter template using Shadow-CLJS and Replicant for the renderer process. This project translates the official Electron tutorial ["Building Your First App"](https://www.electronjs.org/docs/latest/tutorial/tutorial-first-app) to ClojureScript.

## Features

- **Shadow-CLJS** for ClojureScript compilation
- **Replicant** for DOM rendering in the renderer process
- **Hot reloading** for both ClojureScript and Electron (via electron-reload)
- Secure context bridge implementation
- Minimal setup following Electron best practices

## Prerequisites

- Node.js and npm installed
- Basic knowledge of ClojureScript and Electron

## Getting Started

1. Clone this repository
2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development environment:
   ```bash
   npm run dev
   ```

This will:
- Start Shadow-CLJS compilation watchers for both main and renderer processes
- Wait 10 seconds for initial compilation
- Launch the Electron application with hot reloading enabled

## How It Works

1. **Main Process** (`src/main/core.cljs`): Creates the Electron window and manages app lifecycle
2. **Preload Script** (`resources/public/js/preload.js`): Safely exposes Node.js version info to the renderer
3. **Renderer Process** (`src/renderer/core.cljs`): Uses Replicant to display version information

The app demonstrates Electron's security best practices by using a context bridge instead of exposing Node.js directly to the renderer.

## Development Notes

- Hot reloading watches all ClojureScript files and automatically recompiles
- Electron-reload monitors file changes and restarts the app (ignoring node_modules, hidden files, and build output)
- The renderer uses Replicant's virtual DOM for efficient updates

## Resources

- [Electron Documentation](https://www.electronjs.org/docs/latest/)
- [Shadow-CLJS Documentation](https://shadow-cljs.github.io/docs/UsersGuide.html)
- [Replicant Documentation](https://replicant.fun/learn/)

## License

MIT
