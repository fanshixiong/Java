<template>
  <div id="app">
    <main-tab-bar/>
    <router-view/>
  </div>
</template>
<script>
import MainTabBar from 'components/content/mainTabbar/MainTabBar'
export default {
  name: 'app',
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
@import 'assets/css/base.css';
</style>
