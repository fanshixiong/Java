<template>
  <div id="app">
    <div id="nav">
      <router-link to="/" replace>Home</router-link>
      |
      <router-link to="/about" replace>About</router-link>
    </div>
    <router-view/>
    <div id="help">
      <router-link to="/help" tag="button">Help</router-link>
      <!--      <router-view></router-view>-->
      | |
      <router-link :to="'/user/'+userId">User</router-link>
      | |
      <router-link :to="{path:'/profile', query:{ name : 'frans', age : 18, height : 1.99} }">profile</router-link>
      |
      <button @click="userClick">用户</button>
      <button @click="profileClick">档案</button>

    </div>
  </div>
</template>
<script>
export default {
  name: 'App',
  data () {
    return {
      userId: 'frans',
      imgURL: 'www.pornhub.com'
    }
  },
  methods: {
    userClick () {
      this.$router.push('/user/' + this.issuerId)
    },
    profileClick () {
      this.$router.push({
        path: '/profile',
        query: {
          name: 'frans',
          age: 18,
          height: 1.99
        }
      })
    }
  }
}
</script>
<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

  #nav {
    padding: 30px;
  }

  #nav a {
    font-weight: bold;
    color: #2c3e50;
  }

  #nav a.router-link-exact-active {
    color: #42b983;
  }

  #help {
    padding: 40px;
  }

  #help a {
    font-weight: bold;
    color: #833f9b;
  }

  #help a.router-link-exact-active {
    color: #b93238;
  }
</style>
