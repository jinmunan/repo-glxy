import request from '@/utils/request'

export default {
  saveCourseInfo(courseInfo) {
    return request({
      url: '/admin/edu/course/save-course-info',
      method: 'post',
      data: courseInfo
    })
  },
  getCourseInfoById(id) {
    return request({
      url: `/admin/edu/course/course-info/${id}`,
      method: 'get'
    })
  }
}
