export default {
  // context：上下文
  /*
  aUpdateInfo (context, name) {
    setTimeout(() => {
      context.commit('updateName', name)
    }, 1000)
  }
  */
  aUpdateInfo (context, payload) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        context.commit('updateName')
        console.log(payload)
        resolve('11111111')
      }, 1000)
    })
  }
}
