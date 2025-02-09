 export const getImageUrl = (path) => {
    return new URL("/assets/"+ `${path}`, import.meta.url).href;
}
 export default getImageUrl;

// assets / nav / menuIcon.png;

