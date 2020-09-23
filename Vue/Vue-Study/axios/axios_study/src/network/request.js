import axios from 'axios'

export function request (config) {
  const instance = axios.create({
    baseURL: 'http://123.207.32.32:8000/',
    timeout: 5000
  })
  // 拦截器
  instance.interceptors.request.use(config => {
    console.log(config)
    return config // 为什么要return
  }, error => {
    console.log(error)
  })
  // 响应拦截
  instance.interceptors.response.use(res => {
    console.log(res)
    return res.data // 为什么要return
  }, error => {
    console.log(error)
  })
  return instance(config)

  /*
  return new Promise((resolve, reject) => {
      //创建axios实例
      const instance = axios.create({
        baseURL: 'http://123.207.32.32:8000/',
        timeout: 5000
      })

      instance(config)
          .then(res => {
            resolve(res)
          })
          .catch(err => {
            reject(err)
          })
    })
    */
}
