<template>
  <div v-html="test"></div>
</template>

<script>
  import en from './en/hello.md'
  import ja from './ja/hello.md'

  export default {
    data () {
      return { lang: 'en' }
    },
    asyncData (context) {
      return { lang: context.lang }
    },
    computed: {
      test() {
        console.log('Lang:' + this.lang);
        if (this.lang === 'en' || this.lang === undefined) {
          return en;
        } else {
          return ja;
        }
      }
    }
  }
</script>
