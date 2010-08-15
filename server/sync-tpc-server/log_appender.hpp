#ifndef _CHAT_U_VOLCHAT__LOG_APPENDER_HPP_
#define _CHAT_U_VOLCHAT__LOG_APPENDER_HPP_

#include "logger.hpp"

#include <boost/thread/mutex.hpp>

#include <string>

namespace com {
namespace uosipa {
namespace chatuvolchat {
    void append(const log_type& type, const std::string& logger_id, const std::string& line);
} // chatuvolchat
} // uosipa
} // com

#endif // include guard
