find . -type f \
  ! -path '*/\.*' \
  ! -path '*/build/*' \
  ! -path '*/.gradle/*' \
  ! -path '*/.idea/*' \
  ! -path '*/gradle/*' \
  ! -path '*/res/*' \
  \( -name '*.kt' -o -name '*.java' -o -name '*.gradle' -o -name '*.pro' -o -name 'AndroidManifest.xml' -o -name '*.md' \) \
  -exec bash -c 'echo "### FILE: $1" >> android_llm_ready.txt; cat "$1" >> android_llm_ready.txt; echo -e "\n\n" >> android_llm_ready.txt' _ {} \;