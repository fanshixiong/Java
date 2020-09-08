<template>
  <div class="home">
    <h2>Home</h2>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <router-link to="home/page">HomePage</router-link>
    |
    <router-link to="home/message">HomeMessage</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  data () {
    return {
      path: '/home/message'
    }
  },
  activated () {
    console.log('调用actived')
    this.$router.push(this.path)
  },
  // deactivated(){
  //   console.log('调用actived')
  //   console.log(this.$route.path)
  //   this.path = this.$route.path
  // },
  beforeRouterLeave (to, from, next) {
    console.log(this.$route.path)
    this.path = this.$route.path
    next()
  }
}
</script>
