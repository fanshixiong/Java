<template>
  <h2>
    User:Frans__{{userId}}_Login
  </h2>
</template>

<script>
export default {
  name: 'User',
  computed: {
    userId () {
      return this.$route.params.userId
    }
  }
}
</script>

<style scoped>

</style>
