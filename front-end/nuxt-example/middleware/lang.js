export default function (context) {
  context.lang = context.route.path.split('/')[1] === 'ja' ? 'ja' : 'en';
}
