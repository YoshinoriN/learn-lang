<template>
  <h1>{{ user }}</h1>
</template>
<script>
export default {
  async asyncData ({ $axios }) {
    let data = await $axios.$get(`https://api.github.com/users/YoshinoriN`)
    console.log(data);
    return { user: data }
  }
}
</script>
