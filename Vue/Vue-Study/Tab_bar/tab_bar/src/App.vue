<template>
  <div id="app">
    <router-view></router-view>
    <main-tab-bar/>
  </div>
</template>
<script>
import MainTabBar from './components/MainTabBar'

export default {
  name: 'App',
  data () {
    return {

    }
  },
  components: {
    MainTabBar
  },
  methods: {

  }
}
</script>
<style>
  @import './assets/css/base.css';
</style>
