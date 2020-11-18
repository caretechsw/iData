/* flatpickr v4.5.0, @license MIT */
(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? factory(exports) :
    typeof define === 'function' && define.amd ? define(['exports'], factory) :
    (factory((global.zh = {})));
}(this, (function (exports) { 'use strict';

    var fp = typeof window !== "undefined" && window.flatpickr !== undefined ? window.flatpickr : {
      l10ns: {}
    };
    var Mandarin = {
      weekdays: {
        shorthand: [unescape("%u65E5"), unescape("%u4E00"), unescape("%u4E8C"), unescape("%u4E09"), unescape("%u56DB"), unescape("%u4E94"), unescape("%u516D")],
        longhand: [unescape("%u661F%u671F%u65E5"), unescape("%u661F%u671F%u4E00"), unescape("%u661F%u671F%u4E8C"), unescape("%u661F%u671F%u4E09"), unescape("%u661F%u671F%u56DB"), unescape("%u661F%u671F%u4E94"), unescape("%u661F%u671F%u516D")]
      },
      months: {
        shorthand: [unescape("%u4E00%u6708"), unescape("%u4E8C%u6708"), unescape("%u4E09%u6708"), unescape("%u56DB%u6708"), unescape("%u4E94%u6708"), unescape("%u516D%u6708"), unescape("%u4E03%u6708"), unescape("%u516B%u6708"), unescape("%u4E5D%u6708"), unescape("%u5341%u6708"), unescape("%u5341%u4E00%u6708"), unescape("%u5341%u4E8C%u6708")],
        longhand: [unescape("%u4E00%u6708"), unescape("%u4E8C%u6708"), unescape("%u4E09%u6708"), unescape("%u56DB%u6708"), unescape("%u4E94%u6708"), unescape("%u516D%u6708"), unescape("%u4E03%u6708"), unescape("%u516B%u6708"), unescape("%u4E5D%u6708"), unescape("%u5341%u6708"), unescape("%u5341%u4E00%u6708"), unescape("%u5341%u4E8C%u6708")]
      },
      rangeSeparator: unescape("%20%u81F3"),
      weekAbbreviation: unescape("%u5468"),
      scrollTitle: unescape("%u6EFE%u52D5%u5207%u63DB"),
      toggleTitle: unescape("%u9EDE%u64CA%u5207%u63DB%2012/24%20%u5C0F%u6642%u6642%u5236")
    };
    fp.l10ns.zh = Mandarin;
    var zh = fp.l10ns;

    exports.Mandarin = Mandarin;
    exports.default = zh;

    Object.defineProperty(exports, '__esModule', { value: true });

})));
