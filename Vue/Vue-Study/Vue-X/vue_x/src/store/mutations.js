export default {
  increment (state) {
    state.counter++
  },
  decrement (state) {
    state.counter--
  },
  incrementCount (state, count) {
    state.counter += count
  },
  addStu (state, stu) {
    state.students.push(stu)
  },
  updateName (state, name) {
    state.user.name = name
  }
}
