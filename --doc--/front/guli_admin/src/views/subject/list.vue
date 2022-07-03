<template>
  <div class="app-container">
    <el-input
      v-model="filterText"
      placeholder="输入查询条件"
      style="margin-bottom:30px;"/>

    <el-tree
      ref="subjectTree"
      :data="subjectList"
      :props="defaultProps"
      :filter-node-method="filterNode"
      style="margin-top:10px;"/>

  </div>
</template>

<script>
import subjectApi from '@/api/subject'

export default {

  data() {
    return {
      filterText: '', // 过滤文本
      subjectList: [], // 数据列表
      defaultProps: {// 属性列表数据属性的key
        children: 'children',
        label: 'title'
      }
    }
  },

  // 监听 filterText的变化
  watch: {
    filterText(val) {
      this.$refs.subjectTree.filter(val)// 调用tree的filter方法
    }
  },

  created() {
    this.fetchNodeList()
  },

  methods: {
    // 获取远程数据
    fetchNodeList() {
      subjectApi.getNestedTreeList().then(response => {
        this.subjectList = response.data.items
      })
    },

    // 过滤节点
    // 如果没输入任何内容,则显示全部
    // 如果输入内容，返回索引位置
    filterNode(value, data) {
      if (!value) {
        return true
      }
      // 比如说输入java找到了，返回true，输入python，没找到，返回false，indexOf没找到返回值就是-1
      return data.title.toLowerCase().indexOf(value.toLowerCase()) !== -1
    }
  }
}
</script>
