<template>
  <div class="app-container">

    <!--课程预览 TODO-->

    <div style="text-align:center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button :disabled="publishBtnDisabled" type="primary" @click="publish()">发布课程</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      publishBtnDisabled: false // 按钮是否禁用
    }
  },

  methods: {

    // 上一步
    prev() {
      this.$parent.active = 1
    },

    // 下一步
    publish() {
      this.publishBtnDisabled = true
      this.$parent.active = 3
    }
  }
}
</script>
