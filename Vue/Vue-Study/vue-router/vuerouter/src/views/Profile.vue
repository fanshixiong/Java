<template>
  <div>
    <ul>
      <li>MyProfile1</li>
      <li>MyProfile2</li>
      <li>MyProfile3</li>
      <li>MyProfile4</li>
      <h2>{{$route.query.name}}</h2>
      <h2>{{$route.query.age}}</h2>
      <h2>{{$route.query.height}} </h2>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Profile'
}
</script>

<style scoped>

</style>
