<template>
  <img src="~/assets/images/hoge.png">
</template>
<script>
export default {
  mounted(){
    //プラグインで書いたやつをVueコンポーネントで利用できる
    this.$myInjectedFunction('test')
  }
}
</script>
