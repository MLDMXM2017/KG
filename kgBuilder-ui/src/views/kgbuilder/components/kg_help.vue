<template>
  <el-dialog
    title="帮助"
    :visible.sync="dialogVisible"
    width="70%"
    customClass="flowHelp"
  >
    <el-tabs tab-position="left">
      <el-tab-pane label="基本功能">
        <el-divider content-position="left">基本功能</el-divider>
        <div>1. 新增节点,添加连线,快速添加节点和关系</div>
        <div>2. 节点的颜色和大小可修改</div>
        <div>3. 节点和关系的编辑,删除</div>
        <div>4. 导出成图片</div>
        <div>5. csv导入三元组、excel导入单元格树</div>
        <div>6. 导出csv</div>
        <div>7. 添加图片和富文本</div>
        <div>8. 节点之间多个关系</div>
      </el-tab-pane>
      <el-tab-pane label="运行与启动">
        <el-divider content-position="left">安装jdk</el-divider>
        <el-divider content-position="left">安装Neo4j</el-divider>
        <el-divider content-position="left">IDEA 导入项目</el-divider>
        <el-divider content-position="left">配置参数</el-divider>
        <div>找到目录 src/main/resources</div>
        <div>
          修改application.yml,neo4j配置url，password,改成自己的，同理修改mysql（mysql脚本在根目录下，kg_builder.sql）
        </div>
        <el-divider content-position="left">后台打包发布</el-divider>
        <div>
          在idea 右侧 有 maven project
          工具栏，点击展开lifecycle-clean,然后install,等待完成后在控制台可以看见打包的目录，
        </div>
        <div>
          例如：[INFO] Installing
          复制jar包，去windows 或者linux下 切换到jar包目录执行 jar包 java -jar
          xxx.jar 即可启动，springboot配置外部tomcat
        </div>
        <el-divider content-position="left">启动前端</el-divider>
        <div>1.npm install // 安装依赖</div>
        <div>2.npm run serve //启动</div>
        <div>3.npm run build //发布</div>
        <div>启动后访问http://localhost</div>
      </el-tab-pane>
      <el-tab-pane label="注意事项">
        <el-divider content-position="left">图谱三元组导入</el-divider>
        <div>
          支持,.xlsx,.xls,.csv，编码格式一定要是utf-8
          无bom格式的，格式：节点-节点-关系，在本地测试时上传下载的文件要和neo4j在同一台电脑，必须确认neo4j能访问到，否则load不成功
        </div>
        <el-divider content-position="left">图数据库版本与驱动</el-divider>
        <div>本项目适用Neo4j版本3.x版本，对应驱动是1.7.5</div>
        <div>4.x版本，需要升级驱动，对应的utils也需要升级，自行扩展</div>
      </el-tab-pane>
      <el-tab-pane label="源码下载">
        <el-divider content-position="left">github</el-divider>
        <div>
          <a href="https://github.com/MiracleTanC/Neo4j-KGBuilder"
            >https://github.com/MiracleTanC/Neo4j-KGBuilder</a
          >
        </div>
        <el-divider content-position="left">gitee</el-divider>
        <div>
          <a href="https://gitee.com/MiraculousWarmHeart/Neo4j"
            >https://gitee.com/MiraculousWarmHeart/Neo4j</a
          >
        </div>
        <el-divider content-position="left">分支差异</el-divider>
        <div>
          master分支不是前后端分离版本，springboot+thymleaf+vue,嵌入式太深
        </div>
        <div>dev分支是前后端分离版本springboot+vue,前端组件化</div>
      </el-tab-pane>
    </el-tabs>
  </el-dialog>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false
    };
  },
  components: {},
  methods: {
    init() {
      this.dialogVisible = true;
    }
  }
};
</script>

<style>
.flowHelp {
  height: 80%;
}
</style>
