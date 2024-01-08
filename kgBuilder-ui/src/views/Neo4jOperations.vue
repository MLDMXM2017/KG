<template>
  <div>
    <h1>Neo4j Operations</h1>

    <!-- Backup Section -->
    <div>
      <h2>Backup Neo4j Database</h2>
      <input type="text" v-model="backupDataPath" placeholder="Data Path for Backup">
      <input type="text" v-model="backupPath" placeholder="Backup Path">
      <button @click="backupDatabase">Backup Database</button>
    </div>
    <!-- Response Section -->
    <div v-if="response">
      <h3>Response:</h3>
      <pre>{{ response }}</pre>
    </div>
    <!-- Restore Section -->
    <div>
      <h2>Restore Neo4j Database</h2>
      <input type="text" v-model="restoreDataPath" placeholder="Data Path for Restore">
      <button @click="restoreDatabase">Restore Database</button>
    </div>



    <div v-if="restoreResponse">
      <h3>Response:</h3>
      <pre>{{ restoreResponse }}</pre>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import {kgBuilderApi} from "@/api";

export default {
  data() {
    return {
      backupDataPath: '',
      backupPath: '',
      response: null,

      containerName: '',
      restoreDataPath: '',
      dumpFile: '',
      restoreResponse: null // 用于存储响应信息
    };
  },
  methods: {
    async backupDatabase() {
      try {
        const backupData = {
          dataPath: this.backupDataPath, // 这里的 this.dataPath 是用户输入的数据路径
          backupPath: this.backupPath // 同样，this.backupPath 是用户输入的备份路径
        };
        const res = await kgBuilderApi.BackUp(backupData)
        this.response = res.data;
      } catch (error) {
        console.error(error);
        this.response = error.message;
      }
    },
    async restoreDatabase() {
      try {

        const res = await kgBuilderApi.Restore({
          dataPath: this.restoreDataPath}
        ); // 确保有相应的 API 方法
        console.log(res)
        this.restoreResponse = res.data;
      } catch (error) {
        console.error(error);
        this.restoreResponse = error.message;
      }
    }
  }
};
</script>
