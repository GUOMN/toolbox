JENKINS_USER='gitlab_cicd'
#构建参数
JOB_NAME=""
BRANCH=""
PROFILE=""
DEPLOY=""

function getParam() {
  while getopts ":p:d:j:b:" OPTION; do
    case ${OPTION} in
    p)
      PROFILE=${OPTARG}
      ;;
    d)
      DEPLOY=${OPTARG}
      ;;
    j)
      JOB_NAME=${OPTARG}
      ;;
    b)
      BRANCH=${OPTARG}
      ;;
    ?)
      showHelp
      exit 2
      ;;
    esac
  done
  if [ x"" = x"${GRADLE_PROFILE_TYPE}" ]; then
    GRADLE_PROFILE_TYPE="development"
  fi
}

function showHelp() {
  echo "usage: cicd.sh [option...]"
  echo "options:
            -p 构建选项（非必选，FE忽略）development
            -d 不部署 （与jenkins部署tag对应）
            -j Inventory_FE_dev（jenkins中的job名称）
            -b master （构建分支）"
}

function execBuild() {
  curl -I -XPOST -u ${JENKINS_USER}:${TOKEN} "http://jenkins_url:port/job/${JOB_NAME}/buildWithParameters?Project=${JOB_NAME}&branch=${BRANCH}&profile=${PROFILE}&deploy=${DEPLOY}"
}


# 脚本流程
getParam $*
execBuild