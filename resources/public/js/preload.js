console.log('Preload script is running!');
const { contextBridge } = require("electron/renderer");

console.log('contextBridge:', contextBridge);
console.log('process.versions:', process.versions);

try {
	contextBridge.exposeInMainWorld("versions", {
		node: () => process.versions.node,
		chrome: () => process.versions.chrome,
		electron: () => process.versions.electron,
		// we can also expose variables, not just functions
	});
	console.log('contextBridge.exposeInMainWorld completed successfully');
} catch (error) {
	console.error('Error in contextBridge.exposeInMainWorld:', error);
}

// Check if it was exposed
console.log('window.versions after expose:', window.versions);
