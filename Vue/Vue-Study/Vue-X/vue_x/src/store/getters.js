export default {
  powerCounter (state) {
    return state.counter * state.counter
  },
  getStudentCounts: state => {
    return state.students.filter(s => s.age > 20).length
  },
  stuCount () {
    return this.$store.getters.getStudents
  },
  moreAgeStu (state) {
    // return function (age) {
    //   return state.students.filter(s => s.age > age)
    // }
    return age => {
      return state.students.filter(s => s.age > age)
    }
  }
}
